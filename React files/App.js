import './App.css';
import Home from './components/Home';
import NavBar from './components/NavBar';
import { Routes,Route } from 'react-router-dom';
import AddTrainee from './trainee/AddTrainee';
import EditTrainee from './trainee/EditTrainee';
import FooterComponent from './components/FooterComponent';
import View from './components/View';
import Search from './components/Search';
import SearchByAllFields from './components/SearchByAllFields';
import SingleSearch from './components/SingleSearch';
import AutoSearch from './components/AutoSearch';

function App() {
  
  return (
    <div className="App">
        <NavBar />
        <Routes>
      <Route path="/" element={<Home />}/>
      <Route path="/addtrainee" element={<AddTrainee/>}/>
      <Route path="/edit" element={<EditTrainee/>}/>
      <Route path="/view" element={<View/>}/>
      <Route path="/search" element={<Search/>}/>
      <Route path="/searchbyall" element={<SearchByAllFields/>}/>
      <Route path="/autosearch" element={<AutoSearch/>}/>
      </Routes>
      <FooterComponent/>
    </div>
  );
}
export default App;
