import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { Form, Button, Container } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

function RegistrationForm() {
  const navigate = useNavigate()
  const [validationMessages, setValidationMessages] = useState([]);
  const [users, setUsers] = useState([])
  const [places, setPlace] = useState([])
  const [formData, setFormData] = useState({
    studentName: '',
    email: '',
    contactNumber: '',
    address: ''
  });

  useEffect(() => {
    loadAddress();
    loadUsers();
  }, []);

  const { studentName, email, contactNumber, address } = formData;
  const handleChange = (event) => {
    setFormData({ ...formData, [event.target.name]: event.target.value });
    console.log(email)
  }
  const handleSubmit = async (event) => {
    console.log("validation")
    let listMails = [];
    let listNumber = [];
    {
      users.map((user, index) => (
        listMails.push(user.email)
      ))
    }
    {
      users.map((user, index) => (
        listNumber.push(user.contactNumber)
      ))
    }
    for (var i= 0; i < listMails.length; i++) {
      if (email === listMails[i]) {
        alert("Email Id exists")
        return <div className='alert alert-warning'>E-mail Exists</div>
      }
    } 
    for (i= 0; i < listNumber.length; i++) {
      if (contactNumber === listNumber[i]) {
        alert("Contact Number is exists")
        return <div className='alert alert-warning'>Contact Number is exists</div>
      }
    } 
    console.log(formData);
    event.preventDefault();
    await axios.post('http://localhost:8080/connection/trainee', formData, {
      headers: {
        'sheetId': '1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4',
        Accept: 'application/json'
      }
    });
    alert("Registration done successfully");
    navigate('/')
  }
  const loadAddress = async () => {
    const result = await axios.get('http://localhost:8080/connection/trainee/location', {
      headers: {
        'sheetId': ' 1Np5h34vhqj4W2UithqIbNucnJ97url9IcUwyx2OmG50'
      }
    }
    );
    setPlace(result.data);
  }
  const handleCancel = (event) => {
    navigate('/')
  }
  const handleClick = (event) => {
    validateData()
  }
  const loadUsers = async () => {
    const result = await axios.get('http://localhost:8080/trainee/', {
      headers: {
        'sheetId': '1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4'
      }
    }
    );
    setUsers(result.data);
  }

  const validateData = () => {
    setValidationMessages([]);
    let messages = [];
    if (!studentName) {
      messages.push("Name is required");
    }
    if (!email) {
      messages.push("email is required");
    }
    if (!contactNumber) {
      messages.push("contact number is required");
    }
    if (!address) {
      messages.push("address is required");
    }

    setValidationMessages(messages);
  }
  return (
    <Container>
      <Form onSubmit={(event) => handleSubmit(event)}>
        <h2>Trainee Registration Form</h2>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Control type="text" placeholder="Enter Trainee Name" name="studentName" value={studentName} onChange={(event) => handleChange(event)} />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Control type="text" placeholder="Enter E-mail" name="email" id="email" value={email} onChange={(event) => handleChange(event)} />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formContactNumber">
          <Form.Control type="text" placeholder="Enter Contact Number" name="contactNumber" value={contactNumber} onChange={(event) => handleChange(event)} />
        </Form.Group>
      
        <select name="address" onChange={(event) => handleChange(event)}>
          <option >Choose Location</option>
          {
            places.map(place => (
              <option value={places.value} >{place}</option>

            ))
          }
        </select><br></br><br></br>
        <Button type='submit' onClick={handleClick}>Register</Button>
        &nbsp;&nbsp;&nbsp;
        <Button type='submit' onClick={(event) => handleCancel(event)}>Cancel</Button>
      </Form>
      <div>{validationMessages.length > 0 && <span>required values</span>}
        <ul>
          {validationMessages.map(error => <li key={error}>{error}</li>)}
        </ul>
      </div>
    </Container>
  )
}

export default RegistrationForm;