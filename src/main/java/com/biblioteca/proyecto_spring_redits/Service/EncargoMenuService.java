package com.biblioteca.proyecto_spring_redits.Service;

import com.biblioteca.proyecto_spring_redits.Model.EncargoMenu;
import com.biblioteca.proyecto_spring_redits.Repository.EncargoMenuRepository;
import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EncargoMenuService implements IEncargoMenuService {
    private final EncargoMenuRepository encargoMenuRepository;

    @Override
    public List<EncargoMenu> listAll() {
        return encargoMenuRepository.findAll();
    }

    @Override
    public EncargoMenu findById(int id) {
        return encargoMenuRepository.findById(id).orElse(null);
    }

    @Override
    public EncargoMenu save(EncargoMenu encargoMenu) {
        return encargoMenuRepository.save(encargoMenu);
    }

    @Override
    public void delete(int id) {
        encargoMenuRepository.deleteById(id);
    }
}
