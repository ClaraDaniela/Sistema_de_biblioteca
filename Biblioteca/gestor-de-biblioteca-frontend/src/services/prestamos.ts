import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';

export const getPrestamos = () => axios.get(`${BASE_URL}/prestamos`);
export const crearPrestamo = (data: any) => axios.post(`${BASE_URL}/prestamos`, data);
export const editarPrestamo = (id: number, data: any) => axios.put(`${BASE_URL}/prestamos/${id}`, data);
export const eliminarPrestamo = (id: number) => axios.delete(`${BASE_URL}/prestamos/${id}`);