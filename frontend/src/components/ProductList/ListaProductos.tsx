import type { Producto } from "../../models";
import { useEffect, useState } from "react";
import { getAllProducts } from "../../services";



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

  
  return (
        <div>
          <h2 className="text-center">Lista de Productos</h2>
          <table className="table table-hover table-bordered">
            <thead>
              <tr>
                <th>Codigo</th>
                <th>Producto</th>
                <th>Precio de Venta</th>
                <th>Precio de Costo</th>
                <th>Stock</th>
                <th className="text-center">Acciones</th>
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
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      )
}


