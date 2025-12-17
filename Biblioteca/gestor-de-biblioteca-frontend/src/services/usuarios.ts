import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';

export const getUsuarios = () => axios.get(`${BASE_URL}/usuarios`);
export const crearUsuario = (data: any) => axios.post(`${BASE_URL}/usuarios`, data);
export const editarUsuario = (id: number, data: any) => axios.put(`${BASE_URL}/usuarios/${id}`, data);
export const eliminarUsuario = (id: number) => axios.delete(`${BASE_URL}/usuarios/${id}`);