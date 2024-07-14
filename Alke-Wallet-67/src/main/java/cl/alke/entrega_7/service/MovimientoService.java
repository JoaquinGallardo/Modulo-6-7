package cl.alke.entrega_7.service;

import cl.alke.entrega_7.model.Transferencia;
import cl.alke.entrega_7.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoService {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TransferenciaService transferenciaService;

    @Transactional
    public boolean registrarMovimiento(int emisor, int receptor, int monto) {
        System.out.println("Entro a la transaccion de movimiento");
        Usuario usuarioEmisor = usuarioService.getOne(emisor);
        Usuario usuarioReceptor = usuarioService.getOne(receptor);
        System.out.println(usuarioEmisor);
        System.out.println(usuarioReceptor);

        if (usuarioEmisor == null || usuarioReceptor == null) {
            System.out.println();
            return false;
        }

        if (usuarioEmisor.getSaldo() < monto) {
            return false;
        }
        if (monto <= 0) {
            return false;
        }

        Transferencia transferencia = new Transferencia();
        transferencia.setEmisor(usuarioEmisor);
        transferencia.setReceptor(usuarioReceptor);
        transferencia.setMonto(monto);
        transferencia.setFecha("2024-07-10");
        transferenciaService.save(transferencia);

        usuarioEmisor.setSaldo(usuarioEmisor.getSaldo() - monto);
        usuarioReceptor.setSaldo(usuarioReceptor.getSaldo() + monto);

        usuarioService.update(usuarioEmisor);
        usuarioService.update(usuarioReceptor);


        return true;
    }
}
