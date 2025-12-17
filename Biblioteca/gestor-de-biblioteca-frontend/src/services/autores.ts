import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';

export const getAutores = () => axios.get(`${BASE_URL}/autores`);
export const crearAutor = (data: any) => axios.post(`${BASE_URL}/autores`, data);
export const editarAutor = (id: number, data: any) => axios.put(`${BASE_URL}/autores/${id}`, data);
export const eliminarAutor = (id: number) => axios.delete(`${BASE_URL}/autores/${id}`);