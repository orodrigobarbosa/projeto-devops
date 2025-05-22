import React, { useEffect, useState } from 'react';
import api from '../services/api';
import FormularioTarefa from './FormularioTarefa';

function ListaTarefas() {
  const [tarefas, setTarefas] = useState([]);

  const carregarTarefas = async () => {
    try {
      const response = await api.get('');
      setTarefas(response.data);
    } catch (error) {
      console.error('Erro ao carregar tarefas:', error);
    }
  };

  useEffect(() => {
    carregarTarefas();
  }, []);

  const toggleConcluido = async (tarefa) => {
    try {
      const atualizada = { ...tarefa, concluido: !tarefa.concluido };
      await api.put(`/${tarefa.id}`, atualizada);
      carregarTarefas();
    } catch (error) {
      console.error('Erro ao atualizar tarefa:', error);
    }
  };

  const deletarTarefa = async (id) => {
    try {
      await api.delete(`/${id}`);
      carregarTarefas();
    } catch (error) {
      console.error('Erro ao deletar tarefa:', error);
    }
  };

  return (
    <div>
      <h2>Lista de Tarefas</h2>

      <FormularioTarefa onTarefaCriada={carregarTarefas} />

      <ul>
        {tarefas.map(tarefa => (
          <li key={tarefa.id}>
            <strong>{tarefa.titulo}</strong> - {tarefa.descricao} - {tarefa.concluido ? 'Concluída' : 'Pendente'}
            <button onClick={() => toggleConcluido(tarefa)} style={{ marginLeft: '10px' }}>
              {tarefa.concluido ? 'Marcar como Pendente' : 'Marcar como Concluída'}
            </button>
            <button onClick={() => deletarTarefa(tarefa.id)} style={{ marginLeft: '5px', color: 'red' }}>
              Deletar
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListaTarefas;
