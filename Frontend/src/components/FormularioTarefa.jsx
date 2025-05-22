import React, { useState } from 'react';
import api from '../services/api';

function FormularioTarefa({ onTarefaCriada }) {
  const [titulo, setTitulo] = useState('');
  const [descricao, setDescricao] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!titulo.trim()) {
      alert('O título é obrigatório');
      return;
    }

    try {
      const novaTarefa = { titulo, descricao, concluido: false };
      await api.post('', novaTarefa);
      setTitulo('');
      setDescricao('');
      onTarefaCriada();  // Avisar o componente pai para atualizar a lista
    } catch (error) {
      console.error('Erro ao criar tarefa:', error);
      alert('Erro ao criar tarefa. Veja no console.');
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginBottom: '20px' }}>
      <div>
        <input
          type="text"
          placeholder="Título"
          value={titulo}
          onChange={(e) => setTitulo(e.target.value)}
          required
          style={{ marginRight: '10px' }}
        />
        <input
          type="text"
          placeholder="Descrição"
          value={descricao}
          onChange={(e) => setDescricao(e.target.value)}
        />
        <button type="submit" style={{ marginLeft: '10px' }}>Adicionar</button>
      </div>
    </form>
  );
}

export default FormularioTarefa;
