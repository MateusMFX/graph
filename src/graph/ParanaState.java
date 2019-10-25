package graph;

import cern.colt.Arrays;
import graph.algorithm.ListAdjacency;
import graph.viewer.ListAdjacencyViewer;

/**
 *
 * @author uniaodk
 */
public class ParanaState {

    ListAdjacency listAdjacency;
    City cascavel, toledo, foz_do_iguacu, francisco_beltrao, sao_mateus_do_sul,
            paranagua, guarapuava, londrina, ponta_grossa, maringa, umuarama,
            curitiba;
    Vertex casc, tol, foz, fran, sao, para, guara, lond, ponta, marin, umu, curi;
    Link a, b, c, d, e, f, g, h, i, j, k, l, m, n;

    public ParanaState() {
        listAdjacency = new ListAdjacency(new Directable.UnDirected());
        initCity();
        initVertex();
        initLinks();
        addVertexes();
        addLinks();
    }

    private void initCity() {
        cascavel = new City("Cascavel", -24.9577, -53.4595);
        toledo = new City("Toledo", -24.7251, -53.7417);
        foz_do_iguacu = new City("Foz do Iguaçu", -25.5163, -54.5854);
        francisco_beltrao = new City("Francisco Beltrão", -26.0405, -53.175);
        sao_mateus_do_sul = new City("São Mateus do Sul", -25.8681, -50.3842);
        paranagua = new City("Paranaguá", -25.5166, -48.523);
        guarapuava = new City("Guarapuava", -25.3907, -51.4628);
        londrina = new City("Londrina", -23.3045, -51.1696);
        ponta_grossa = new City("Ponta Grossa", -25.0994, -50.1585);
        maringa = new City("Maringá", -23.4209, -51.933);
        umuarama = new City("Umuarama", -23.7661, -53.3206);
        curitiba = new City("Curitiba", -25.42, -49.2651);
    }

    private void initVertex() {
        casc = new Vertex(cascavel);
        tol = new Vertex(toledo);
        foz = new Vertex(foz_do_iguacu);
        fran = new Vertex(francisco_beltrao);
        sao = new Vertex(sao_mateus_do_sul);
        para = new Vertex(paranagua);
        guara = new Vertex(guarapuava);
        lond = new Vertex(londrina);
        ponta = new Vertex(ponta_grossa);
        marin = new Vertex(maringa);
        umu = new Vertex(umuarama);
        curi = new Vertex(curitiba);
    }

    private void initLinks() {
        a = new Link("A").withVertex(casc).withAdjacent(tol).withCost(50);
        b = new Link("B").withVertex(casc).withAdjacent(foz).withCost(143);
        c = new Link("C").withVertex(casc).withAdjacent(fran).withCost(186);;
        d = new Link("D").withVertex(casc).withAdjacent(guara).withCost(250);
        e = new Link("E").withVertex(tol).withAdjacent(umu).withCost(126);
        f = new Link("F").withVertex(umu).withAdjacent(marin).withCost(190);
        g = new Link("G").withVertex(marin).withAdjacent(lond).withCost(114);
        h = new Link("H").withVertex(marin).withAdjacent(ponta).withCost(314);
        i = new Link("I").withVertex(lond).withAdjacent(ponta).withCost(273);
        j = new Link("J").withVertex(guara).withAdjacent(ponta).withCost(165);
        k = new Link("K").withVertex(fran).withAdjacent(sao).withCost(354);
        l = new Link("L").withVertex(sao).withAdjacent(curi).withCost(157);
        m = new Link("M").withVertex(curi).withAdjacent(para).withCost(90);
        n = new Link("N").withVertex(ponta).withAdjacent(curi).withCost(114);
    }

    private void addVertexes() {
        listAdjacency.addVertex(casc).addVertex(tol).addVertex(foz)
                .addVertex(fran).addVertex(sao).addVertex(para).addVertex(guara)
                .addVertex(lond).addVertex(ponta).addVertex(marin).addVertex(umu)
                .addVertex(curi);
    }

    private void addLinks() {
        listAdjacency.addLink(a).addLink(b).addLink(c).addLink(d)
                .addLink(e).addLink(f).addLink(g).addLink(h).addLink(i)
                .addLink(j).addLink(k).addLink(l).addLink(m)
                .addLink(n);
    }
    
    public ListAdjacency getListAdjacency(){
        return listAdjacency;
    }

    public void show() {
        System.out.println(ListAdjacencyViewer.status(listAdjacency));
    }

}
