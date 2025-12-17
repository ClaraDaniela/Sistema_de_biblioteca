import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';

export const getMultas = () => axios.get(`${BASE_URL}/multas`);
export const crearMulta = (data: any) => axios.post(`${BASE_URL}/multas`, data);
export const editarMulta = (id: number, data: any) => axios.put(`${BASE_URL}/multas/${id}`, data);
export const eliminarMulta = (id: number) => axios.delete(`${BASE_URL}/multas/${id}`);