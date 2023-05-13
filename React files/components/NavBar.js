import React from 'react';
import { Link ,NavLink} from 'react-router-dom';
import { Nav, Navbar } from 'react-bootstrap';
function NavBar() {
  return (

    <Navbar collapseOnSelect expand="sm" bg="dark" variant="dark">
      <Navbar.Toggle aria-controls="navbarScroll" data-bs-target="#navbarScroll"/>
      <Navbar.Collapse id="navbarScroll">
        <Nav>
        <img src='https://www.x-workz.in/Logo.png'  width={60} height={40}></img>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/">Home</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/addtrainee">Add trainee</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/view">View</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/search">Search</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/searchbyall">Searchwithsuggestion</NavLink>
            <NavLink className="btn btn-primary nav-link" as={Link} to="/autosearch">AutoSearch</NavLink>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  )
}
export default NavBar;