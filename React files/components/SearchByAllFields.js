import React, { useState } from 'react'
import { Button, Col, Container, Form, Row} from "react-bootstrap";
import axios from 'axios'

export default function AutoSuggest() {
    const [value,setValue] = useState('');
    const [users, setUsers] = useState([])
    const [name, setName] = useState("")
    const apiurl = 'http://localhost:8080/connection/trainee/';
  
  const loadUsers = async () => {
    const result = await axios.get(apiurl, {
      headers: {
        'sheetId': '1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4'
      }
    }
    );
    setUsers(result.data);
  }

    const onChange=(event)=>{
        setValue(event.target.value);
    }

    const onSearch =(searchTerm)=>{
        loadUsers();
    }
  
    return (
        <Container className="mt-5">
            <Row>
                <Col sm={4}>
                    <Form className="d-flex">
                        <Form.Control
                            type="text"
                            placeholder="Search"
                            className="me-2"
                            aria-label="Search"
                            value={value} onChange={onChange}
                            onKeyDown={()=>onSearch(value)}
                        />
                        <Button>
                            Search
                        </Button>
                    </Form>
                </Col>
                </Row>
            <div className="dropdown">
                            {
                                users.sort().filter(item=>{
                                    const searchTerm=value.toLowerCase();
                                    const name=item.contactNumber.toLowerCase();
                                    return name.startsWith(searchTerm)&& name!==searchTerm;
                                }).slice(0,10)
                                .map((item)=>(
                                <div onClick ={()=>onSearch(item.contactNumber)}className="dropdown-row" key={item.studentName}>
                                    {item.contactNumber}
                                    </div>
                            ))}
                            </div>
            </Container>
    )
}
