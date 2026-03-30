import type { Producto } from "../../models";
import { useEffect, useState } from "react";
import { deleteProducto, getAllProducts} from "../../services";



export const ProductList = () => {
  const [products, setProducts] = useState<Producto[]>();
  //const [error, setError] = useState<Error>();
  //const [loading, setLoading] = useState<boolean>(true);
  //const [productToEdit, setProductToEdit] = useState<Producto | null>(null);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await getAllProducts();
        setProducts(response.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchProducts();
  }, []);

  const handleDelete = async(codigo: string) => {
    try{
        if(window.confirm("Seguro de eliminar el producto?")){
          await deleteProducto(codigo)
          window.alert("Producto Eliminado")
          setProducts(products?.filter(product => product.codigoProducto != codigo))
        }
      }catch (error) {
      console.error("Error al eliminar:", error);
      alert("No se pudo eliminar el producto");
    }
  }
  
  return (
        <div>
          <h2 className="text-center ">Lista de Productos</h2>
          <table className="table table-hover table-bordered ">
            <thead>
              <tr className="table-primary">
                <th>Codigo</th>
                <th>Producto</th>
                <th>Precio de Venta</th>
                <th>Precio de Costo</th>
                <th>Stock</th>
                <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
              {products?.map((p) => {
                return (
                  <tr key={p.codigoProducto}>
                    <td>{p.codigoProducto}</td>
                    <td>{p.nombre}</td>
                    <td>{p.precioVenta}</td>
                    <td>{p.precioCosto}</td>
                    <td>{p.stock}</td>
                    <td>
                      <button className="btn btn-danger" onClick={()=> handleDelete(p.codigoProducto)}> <i className="bi bi-trash"></i> Eliminar</button>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      )
}


