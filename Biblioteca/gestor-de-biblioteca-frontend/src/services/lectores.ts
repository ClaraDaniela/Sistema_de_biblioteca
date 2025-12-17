import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';

export const getLectores = () => axios.get(`${BASE_URL}/lectores`);
export const crearLector = (data: any) => axios.post(`${BASE_URL}/lectores`, data);
export const editarLector = (id: number, data: any) => axios.put(`${BASE_URL}/lectores/${id}`, data);
export const eliminarLector = (id: number) => axios.delete(`${BASE_URL}/lectores/${id}`);