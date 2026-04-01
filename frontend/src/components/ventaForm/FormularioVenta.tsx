import { useForm } from "react-hook-form"
import type { DetalleVenta, Producto } from "../../models";
import { useEffect, useState } from "react";
import { getAllProducts } from "../../services";
import { presupuestoVenta } from "../../services/venta.service";

export const FormularioVenta = () =>{
    const {register} = useForm()
    const [products, setProducts] = useState<Producto[]>();
    const [error, setError] = useState<Error>();
    const [productoSeleccionado, setProductoSeleccionado] = useState<String>("");
    const [cantidadSeleccionada, setCantidadSeleccionada] = useState<number>(0);
    const [carrito, setCarrito] = useState<DetalleVenta[]>([]);
    const [total, setTotal] = useState<number>(0);


    useEffect(() => {
        const fetchProducts = async () => {
          try {
            const response = await getAllProducts();
            setProducts(response.data);
            
          } catch (error: any) {
            console.log(error);
            setError(error)
          }
        };
        fetchProducts();
      }, []);

    if(error){
        return(<h1>Ocurrio un error: {error.message}</h1>)
    }

    const agregarAlCarrito = () => {
        const productoAAñadir = products?.find((p)=> p.codigoProducto === productoSeleccionado)
        
        console.log(cantidadSeleccionada)
        console.log(productoSeleccionado)
        
        if(productoAAñadir && cantidadSeleccionada > 0){
            const nuevoDetalle: DetalleVenta = {
                producto: productoAAñadir,
                cantidad: cantidadSeleccionada
            }
            setCarrito([...carrito, nuevoDetalle])
        }

        
    }
    useEffect(() => {
            const calcularTotal = async () => {
                if (carrito.length === 0) {
                    setTotal(0);
                    return;
                }
                try {
                    const response = await presupuestoVenta(carrito);
                    console.log(response.data)
                    setTotal(response.data); 
                } catch (err) {
                    console.error("Error al calcular presupuesto:", err);
                }
            };
            calcularTotal();
        }, [carrito]);


    return(
        <>
            <h1> Nueva Venta </h1>
            <form className="form-floating">
                {/*combo box eleccion de productos */}
                <div className="form-floating mb-3 form-group">
                    <div className="form-group">
                        <label htmlFor="opciones" className="col-xs-2 col-form-label">Seleccione el producto</label>
                        <select className="form-select" id="opciones" name="opciones" onChange={(e)=> setProductoSeleccionado(e.target.value)}>
                            <option selected>Seleccione un producto</option>
                            {products?.map((p) => {return(
                                <option key={p.codigoProducto} value={p.codigoProducto}> {p.codigoProducto} | {p.nombre} | stock: {p.stock}</option>
                            )})}
                        </select>
                    </div>
                </div>
                
                {/* input ingreso cantidad del producto */}
                <div className="form-floating mb-3">
                    <input type="number" id="cantidad" name="cantidad" className="form-control" onChange={(e)=> setCantidadSeleccionada(Number(e.target.value))}/>
                    <label htmlFor="cantidad">Ingrese la cantidad del producto:</label>
                </div>
                <button type="button" className="btn btn-primary" onClick={agregarAlCarrito}> Añadir al carrito    <i className="bi bi-plus-circle"></i></button>
                
                {/* Carrito */}
                <div className="mt-4">
                    <h3>Resumen del Carrito</h3>
                    <ul className="list-group">
                    {carrito.map((item, index) => (
                        <li className="list-group-item" key={index}>
                            Producto: {item.producto?.nombre} - Cantidad: {item.cantidad}
                        </li>
                    ))}
                    </ul>
                </div>
                <div className="d-flex justify-content-end">
                        <h4>Total: <span className="badge bg-success">${total}</span></h4>
                </div>
            </form>
            
        </>
    )
}