package sarah.com.br.provacliente.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@GetMapping("/cliente")
public class ClienteResource {

  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping("/todos")
  public List<ListarTodosClientes>() { return clienteRepository.findAll();}
}
