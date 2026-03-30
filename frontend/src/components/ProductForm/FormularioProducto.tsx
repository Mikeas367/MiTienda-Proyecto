export const FormularioProducto = () => {
    return(
        <>
        <h1>Formulario de Producto</h1>

        <form className="form-floating">
            <div className="form-floating mb-3">
                <input className="form-control" type="text" id="codigoProducto" name="codigoProducto"></input>
                <label htmlFor="codigoProducto">Codigo del producto: </label>
            </div>

            <div className="form-floating mb-3">
                <input className="form-control" type="text" id="nombre" name="nombre"></input>
                <label htmlFor="nombre">Nombre del Producto: </label>
            </div>

            <div className="form-floating mb-3">
                <input className="form-control" type="number" id="precioCosto" name="precioCosto" ></input>
                <label htmlFor="precioCosto">Precio de Costo: </label>
            </div>

            <div className="form-floating mb-3">
                <input className="form-control" type="number" id="precioVenta" name="precioVenta"></input>
                <label htmlFor="precioVenta">Precio de Venta: </label>
            </div>
            <div className="form-floating mb-3">
                <input className="form-control" type="number" id="stock" name="stock"></input>
                <label htmlFor="stock">Stock: </label>
            </div>

            <button type="submit" className="btn btn-primary">
                Enviar
            </button>
            
        </form>
        </>
    )
}