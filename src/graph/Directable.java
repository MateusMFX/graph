package graph;

import graph.algorithm.ListAdjacency;

/**
 * Interface para implementação dos tipos de lista adjacente, direcional e não
 * direcional, para controle das ligações.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public interface Directable {
    
    public static Directable copy(Directable copy){
        return copy.getClass() == Directable.UnDirected.class
                ? new Directable.UnDirected() : new Directable.Directed();
    }
    
    public void addLink(ListAdjacency list, Link link);
    
    public void removeLink(ListAdjacency list, Link link);

    /**
     * Classe que implementa os métodos da interface Directable, ou seja, os
     * métodos de adicionar e remover ligações é diferente para o tipo
     * direcional e não direcional.
     *
     * @author uniaodk <uniaodk@gmail.com>
     */
    public class Directed implements Directable {
        
        @Override
        public void addLink(ListAdjacency list, Link link) {           
            list.getList().get(link.getVertex()).add(link.getAdjacent());
        }
        
        @Override
        public void removeLink(ListAdjacency list, Link link) {
            list.getList().get(link.getVertex()).remove(link.getAdjacent());
        }
        
    }

    /**
     * Classe que implementa os métodos da interface Directable, ou seja, os
     * métodos de adicionar e remover é diferente para o tipo direcional e não
     * direcional.
     *
     * @author uniaodk <uniaodk@gmail.com>
     */
    public class UnDirected implements Directable {
        
        @Override
        public void addLink(ListAdjacency list, Link link) {
            new Directed().addLink(list, link);
            list.getList().get(link.getAdjacent()).add(link.getVertex());
        }
        
        @Override
        public void removeLink(ListAdjacency list, Link link) {
            new Directed().removeLink(list, link);
            list.getList().get(link.getAdjacent()).remove(link.getVertex());
        }
        
    }
    
}
