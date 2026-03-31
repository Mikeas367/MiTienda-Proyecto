import { useForm } from "react-hook-form"
import type { Producto } from "../../models";
import { useEffect, useState } from "react";
import { getAllProducts } from "../../services";

export const FormularioVenta = () =>{
    const {register} = useForm()
    const [products, setProducts] = useState<Producto[]>();
    const [error, setError] = useState<Error>();
    const [productoSeleccionado, setProductoSeleccionado] = useState<String>("");
    const [carrito, setCarrito] = useState<Producto[]>([]);


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
        if(productoAAñadir){
            setCarrito([...carrito, productoAAñadir])
        }
    }


    return(
        <>
            <h1> Nueva Venta </h1>
            <form className="form-floating">

            <select className="form-select" id="opciones" name="opciones" onChange={(e)=> setProductoSeleccionado(e.target.value)}>
                <option selected>Seleccione un producto</option>
                {products?.map((p) => {return(
                    <option key={p.codigoProducto} value={p.codigoProducto}> {p.codigoProducto} | {p.nombre}</option>
                )})}
            </select>

            <button type="button" className="btn btn-primary" onClick={agregarAlCarrito}> Añadir al carrito    <i className="bi bi-plus-circle"></i></button>

            </form>
        </>
    )
}