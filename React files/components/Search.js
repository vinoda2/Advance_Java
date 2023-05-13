import React, { useState } from 'react'
import { Button, Col, Container, Form, Row, Table } from "react-bootstrap";
import axios from 'axios'

export default function Search() {
  const [users, setUsers] = useState([])
  const [emails, setEmail] = useState("")
  const [contact, setContact] = useState("")
  const [traineeName, setTraineeName] = useState("")

  const handleEmailInput = (event) => {
    setEmail(event.target.value)
  }
  const handleEmailSearch = async () => {
    const result = await axios.get(`http://localhost:8080/connection/trainee/email/${emails}`, {
      headers: {
        'sheetId': '1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4'
      }
    }
    );
    setUsers(result.data);
  }

  const handleContactNumberSearch = async () => {
    const result = await axios.get(`http://localhost:8080/connection/trainee/contact/${contact}`, {
      headers: {
        'sheetId': '1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4'
      }
    }
    );
    setUsers(result.data);
  }
  const handleContactInput = (event) => {
    setContact(event.target.value)
  }

  const handleNameSearch = async () => {
    const result = await axios.get(`http://localhost:8080/connection/trainee/byname/${traineeName}`, {
      headers: {
        'sheetId': '1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4'
      }
    }
    );
    setUsers(result.data);
  }

  const handleNameInput = (event) => {
    setTraineeName(event.target.value)
  }
  return (
    <Container className="mt-5">
      <Row>
        <Col sm={4}>
          <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search by email"
              className="me-2"
              aria-label="Search"
              value={emails}
              onChange={handleEmailInput}
            />
            <Button onClick={handleEmailSearch}>
              Search
            </Button>
          </Form>
        </Col>
        <Col sm={4}>
          <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search by contact Number"
              className="me-2"
              aria-label="Search"
              onChange={handleContactInput}
            />
            <Button onClick={handleContactNumberSearch}>
              Search
            </Button>
          </Form>
        </Col>
        <Col sm={4}>
          <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search by trainee name"
              className="me-2"
              aria-label="Search"
              onChange={handleNameInput}
            />
            <Button onClick={handleNameSearch}>
              Search
            </Button>
          </Form>
        </Col>
      </Row>
      <h3>Candidate Details</h3>
      <Table bordered>
        <thead>
          <tr>
            <th>Name</th>
            <th>E-mail</th>
            <th>Contact Number</th>
            <th>Location</th>
          </tr>
        </thead>
        <tbody>
          <tr className='table-light'>
            <td>{users.studentName}</td>
            <td>{users.email}</td>
            <td>{users.contactNumber}</td>
            <td>{users.address}</td>
          </tr>
        </tbody>
      </Table>
    </Container>
  )
}