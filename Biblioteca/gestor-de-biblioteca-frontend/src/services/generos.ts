import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';

export const getGeneros = () => axios.get(`${BASE_URL}/generos`);
export const crearGenero = (data: any) => axios.post(`${BASE_URL}/generos`, data);
export const editarGenero = (id: number, data: any) => axios.put(`${BASE_URL}/generos/${id}`, data);
export const eliminarGenero = (id: number) => axios.delete(`${BASE_URL}/generos/${id}`);