import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';

export const getLibros = () => axios.get(`${BASE_URL}/libros`);
export const crearLibro = (data: any) => axios.post(`${BASE_URL}/libros`, data);
export const editarLibro = (id: number, data: any) => axios.put(`${BASE_URL}/libros/${id}`, data);
export const eliminarLibro = (id: number) => axios.delete(`${BASE_URL}/libros/${id}`);