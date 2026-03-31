

const apiBaseUrl = 'http://localhost:8080/api'

export const apiRoutes = {
    PRODUCTOS:{
        ALL_PRODUCTOS: `${apiBaseUrl}/productos`,
        BY_CODIGO_PRODUCTO: (codigo: string) => `${apiBaseUrl}/productos/${codigo}`,
        NUEVO_PRODUCTO: `${apiBaseUrl}/productos/nuevo-producto`,
        ELIMINAR_PRODUCTO: (codigo: string) => `${apiBaseUrl}/productos/eliminar-producto/${codigo}`,
    },
    PRODUCTS: `${apiBaseUrl}/productos`,
    SALES: `${apiBaseUrl}/sales`
}