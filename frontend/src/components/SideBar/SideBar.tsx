
import { Link } from 'react-router-dom';
import './Sidebar.css'

export const SideBar = () =>  {
    return(
    <>
    <div className="sidebar">
        <h1 className="sidebar-title">Menú</h1>
        <ul className="nav flex-colum">
            {/* Inicio */}
            <li className='nav-item'>
                <Link to="/" className='nav-link'>
                    Inicio
                </Link>
            </li>

            {/* Listado de Productos */}
            <li className='nav-item'>
                <Link to="/products" className='nav-link'>
                    <i className="bi bi-box-seam-fill"></i>  Productos   
                </Link>
            </li>

            {/* Formulario nuevo Producto */}
            <li className='nav-item'>
                <Link to="/products/new-product" className='nav-link'>
                    Nuevo Producto   
                </Link>
            </li>

            {/* Formulario nueva Venta */}
            <li className='nav-item'>
                <Link to="/products/new-sale" className='nav-link'>
                    <i className="bi bi-cart-fill"></i>  Nueva Venta  
                </Link>
            </li>
        </ul>
        
    </div>  

    </>
)
}

export default SideBar;