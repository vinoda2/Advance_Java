import React, { useEffect, useState } from 'react'
import axios from 'axios'
import {  Button, Container, Table} from 'react-bootstrap';
import { Link, useNavigate } from 'react-router-dom';

function View() {
  const apiurl = 'http://localhost:8080/connection/trainee/';
  let navigate = useNavigate()
  const [users, setUsers] = useState([])
  const [records,setRecords] =useState([])

  useEffect(() => {
    loadUsers();
  }, []);
  
  const loadUsers = async () => {
    const result = await axios.get(apiurl, {
      headers: {
        'sheetId': '1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4'
      }
    }
    );
    setUsers(result.data);
    setRecords(result.data);
  }
  
  const onDelete = (email) => {
    axios.delete(apiurl + email, {
      headers: {
        "sheetId": "1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4"
      }
    });
    alert("Reacord deleted")
    navigate('/');
  } 

  const Filter=(event)=>{
    setRecords(users.filter(f=>f.studentName.toLowerCase().includes(event.target.value)))
  }

  return (
    <Container>
      <h3>Candidate Details</h3>
      <input type='text' className='form-control' onChange={Filter} placeholder='Search records'/>
      <Table bordered>
        <thead>
          <tr>
            <th>Sl No</th>
            <th>Name</th>
            <th>E-mail</th>
            <th>Contact Number</th>
            <th>Location</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {
            records.map((user, index) => (
              <tr className='table-light'>
                <th key={index}>{index + 1}</th>
                <td>{user.studentName}</td>
                <td>{user.email}</td>
                <td>{user.contactNumber}</td>
                <td>{user.address}</td>
                <td>
                <Link className="btn btn-outline-primary" to={'/edit'} state={user}>Update</Link>
                  &nbsp;&nbsp;&nbsp;
                  <Button variant="danger" onClick={() => onDelete(user.email)}>Delete</Button>
                </td>
              </tr>
            ))}
        </tbody>
      </Table>
    </Container>
  )
}
export default View;