/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.glass.events.WheelEvent;
import ifpb.dac.contexto.pessoa.CadastroPessoaService;
import ifpb.dac.contexto.pessoa.Pessoa;
import ifpb.dac.contexto.pessoa.ReposistorioDePessoa;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

/**
 *
 * @author NandaPC
 */
public class TesteCadPesService {
    
    private CadastroPessoaService cadastroPessoaService;
    private ReposistorioDePessoa reposistorioDePessoa;
    
    public TesteCadPesService() {
    }
    
    @Test
    public void testSalvar(){
        
        reposistorioDePessoa = mock(ReposistorioDePessoa.class);
        cadastroPessoaService = new CadastroPessoaService(reposistorioDePessoa);
        
        Pessoa p = new Pessoa("Fernanda");
        
        Mockito.when(reposistorioDePessoa.salvar(p)).thenReturn(Boolean.TRUE);
        
        assertTrue(cadastroPessoaService.salvar(p));
        
    }
    
    @Test
    public void testListar(){
        
        reposistorioDePessoa = mock(ReposistorioDePessoa.class);
        
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        Pessoa pessoa = new Pessoa("Rodolfo");
        pessoas.add(pessoa);
        
        Mockito.when(reposistorioDePessoa.todos()).thenReturn(pessoas);
        
        assertNotNull(reposistorioDePessoa.todos());
        
    }

}
