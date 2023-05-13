import axios from 'axios';
import React from 'react'
import { Form, Button, Container } from 'react-bootstrap';
import { useNavigate, useLocation } from 'react-router-dom';
import { useState } from 'react';

export default function EditTrainee() {
  const location = useLocation();
  const propsData = location.state;

  let navigate = useNavigate()
  const [user, setFormData] = useState({
    studentName: '',
    email: '',
    contactNumber: '',
    address: ''
  });
  // const {studentName, email, contactNumber, address}=formData
  const handleChange = (event) => {

    const { name, value } = event.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(user)
    axios.put('http://localhost:8080/connection/trainee/', user, {
      headers: {
        'sheetId': '1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4',
        Accept: 'application/json'
      }
    });
    alert("Update done successfully");
    navigate('/');
  }
  const handleCancel = (event) => {
    navigate('/')
  }
  return (
    <Container>
      <Form onSubmit={(event) => handleSubmit(event)}>
      <Form.Label>Update Trainee Details</Form.Label>
        <Form.Group className="mb-3" controlId="formName">
          <Form.Control type="text" defaultValue={propsData.studentName} name="studentName" onChange={(event) => handleChange(event)} />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Control type="text" defaultValue={propsData.email} name="email" onChange={(event) => handleChange(event)} />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formContactNumber">
          <Form.Control type="text" defaultValue={propsData.contactNumber} name="contactNumber" onChange={(event) => handleChange(event)} required />
        </Form.Group>
        <Form.Group className="mb-6" controlId="formContactNumber" >
          <Form.Control type="text" defaultValue={propsData.address} name="address" onChange={(event) => handleChange(event)} required />
        </Form.Group>
        <br></br>
        <Button type='submit'>Update</Button>
        &nbsp;&nbsp;&nbsp;
        <Button type='submit' onClick={(event) => handleCancel(event)}>Cancel</Button>
      </Form>
    </Container>
  )
}


