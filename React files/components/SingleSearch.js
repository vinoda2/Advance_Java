import { useState } from 'react';
import axios from 'axios'

function Autosuggest() {
  const [inputValue, setInputValue] = useState('');
  const [users, setUsers] = useState([])
  const [suggestions, setSuggestions] = useState([]);
  const [currentSection, setCurrentSection] = useState('');
  
  const apiurl = 'http://localhost:8080/connection/trainees/';

  const loadUsers = async () => {
    const result = await axios.get(apiurl, {
      headers: {
        'sheetId': '1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4'
      }
    }
    );
    setUsers(result.data);
    const data=result.data;
    return data.suggestions;
  }

  async function handleInputChange(event) {
    const input = event.target.value;
    setInputValue(input);
    const fetchedSuggestions = await loadUsers(input);
    setSuggestions(fetchedSuggestions);
    setCurrentSection('');
  }

  function handleSuggestionClick(suggestion) {
    setInputValue(suggestion);
    setSuggestions([]);
  }

  function handleSectionChange(section) {
    setCurrentSection(section);
  }

  function renderSuggestions(section) {
    return suggestions[section].map(suggestion => (
      <li key={suggestion} onClick={() => handleSuggestionClick(suggestion)}>
        {suggestion}
      </li>
    ));
  }

  function renderTabs() {
    return Object.keys(suggestions).map(section => (
      <button
        key={section}
        onClick={() => handleSectionChange(section)}
        className={currentSection === section ? 'active' : ''}
      >
        {section}
      </button>
    ));
  }
  return (
    <div className="autosuggest">
      <input type="text" value={inputValue} onChange={handleInputChange} />
      <div className="tabs">{renderTabs()}</div>
      <ul className="suggestions">{renderSuggestions(currentSection)}</ul>
    </div>
  );
}

export default Autosuggest;