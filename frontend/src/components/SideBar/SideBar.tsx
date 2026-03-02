
import { Link } from 'react-router-dom';
import './Sidebar.css'

export const SideBar = () =>  {
    return(
    <>
    <div className="sidebar">
        <h1 className="sidebar-title">Menú</h1>
        <ul className="nav flex-colum">
            <li className='nav-item'>
                <Link to="/" className='nav-link'>
                    Inicio
                </Link>
            </li>
            <li className='nav-item'>
                <Link to="/products" className='nav-link'>
                    Productos   
                </Link>
            </li>
        </ul>
        
    </div>  

    </>
)
}

export default SideBar;