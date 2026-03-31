import { useForm } from "react-hook-form"
import type { Producto } from "../../models"
import { nuevoProducto } from "../../services"


export const FormularioProducto = () => {

    const{register, handleSubmit} = useForm<Producto>()

    const envioFormulario = handleSubmit(async (data: Producto) => {
        console.log("Se envia el formulario")
        console.log(data)
        try {
            await nuevoProducto(data)
            window.alert("Se guardo exitosamente el producto")
        } catch (error) {
            console.log(error)
            window.alert("Error al guardar el producto")
        }
        
        
    })

    return(
        <>
        <h1>Formulario de Producto</h1>

        <form className="form-floating" onSubmit={envioFormulario}>
            <div className="form-floating mb-3">
                <input className="form-control" type="text" id="codigoProducto" {...register("codigoProducto")}>
                </input>
                <label htmlFor="codigoProducto">Codigo del producto: </label>
            </div>

            <div className="form-floating mb-3">
                <input className="form-control" type="text" id="nombre" {...register("nombre")}></input>
                <label htmlFor="nombre">Nombre del Producto: </label>
            </div>

            <div className="form-floating mb-3">
                <input className="form-control" type="number" id="precioCosto" {...register("precioCosto")}></input>
                <label htmlFor="precioCosto">Precio de Costo: </label>
            </div>

            <div className="form-floating mb-3">
                <input className="form-control" type="number" id="precioVenta" {...register("precioVenta")}></input>
                <label htmlFor="precioVenta">Precio de Venta: </label>
            </div>

            <div className="form-floating mb-3">
                <input className="form-control" type="number" id="stock" {...register("stock")}></input>
                <label htmlFor="stock">Stock: </label>
            </div>

            <button type="submit" className="btn btn-primary">
                Guardar <i className="bi bi-floppy"></i> 
            </button>
        </form>
        </>
    )
}