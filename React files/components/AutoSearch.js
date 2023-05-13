import React, { useState, useEffect, useMemo } from "react";
import axios from "axios";
import { Form, Container, Table} from 'react-bootstrap';

const AutoSuggest = () => {
  const [query, setQuery] = useState("");
  const [suggestions, setSuggestions] = useState([]);

  const fetchSuggestions = async () => {
    const response = await axios.get('http://localhost:8080/connection/trainees/search/'+query,{
      headers: {
        'sheetId': '1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4'
      }
    });
    setSuggestions(response.data);
    console.log(response.data)
  };

  useEffect(() => {
    if (query.length === 3) {
      console.log(query)
      fetchSuggestions();
    }
  }, [query]);

  return (
    <Container>
    <h3>Candidate Details</h3>
    <Form.Control
              type="search"
              placeholder="Search by name or email or contact number or address"
              value={query}
              onChange={(e) => setQuery(e.target.value)}
    />
    <Table bordered>
      <thead>
        <tr>
          <th>Sl No</th>
          <th>Name</th>
          <th>E-mail</th>
          <th>Contact Number</th>
          <th>Location</th>
        </tr>
      </thead>
      <tbody>
        {
          suggestions.map((user, index) => (
            <tr className='table-light'>
              <th key={index}>{index + 1}</th>
              <td key ={user.studentName}>{user.studentName}</td>
              <td>{user.email}</td>
              <td>{user.contactNumber}</td>
              <td>{user.address}</td>
            </tr>
          ))}
      </tbody>
    </Table>
  </Container>
  );
};

export default AutoSuggest;
