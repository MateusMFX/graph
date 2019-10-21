package graph.mockup;

import graph.Directable;
import graph.Link;
import graph.Vertex;
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
    Link l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;

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
        l1 = new Link("L1").withVertex(casc).withAdjacent(tol).withCost(50);
        l2 = new Link("L2").withVertex(casc).withAdjacent(foz).withCost(143);
        l3 = new Link("L3").withVertex(casc).withAdjacent(fran).withCost(186);;
        l4 = new Link("L4").withVertex(casc).withAdjacent(guara).withCost(250);
        l5 = new Link("L5").withVertex(tol).withAdjacent(umu).withCost(126);
        l6 = new Link("L6").withVertex(umu).withAdjacent(marin).withCost(190);
        l7 = new Link("L7").withVertex(marin).withAdjacent(lond).withCost(114);
        l8 = new Link("L8").withVertex(marin).withAdjacent(ponta).withCost(314);
        l9 = new Link("L9").withVertex(lond).withAdjacent(ponta).withCost(273);
        l10 = new Link("L10").withVertex(guara).withAdjacent(ponta).withCost(165);
        l11 = new Link("L11").withVertex(fran).withAdjacent(sao).withCost(354);
        l12 = new Link("L12").withVertex(sao).withAdjacent(curi).withCost(157);
        l13 = new Link("L13").withVertex(curi).withAdjacent(para).withCost(90);
        l14 = new Link("L14").withVertex(ponta).withAdjacent(curi).withCost(114);
    }

    private void addVertexes() {
        listAdjacency.addVertex(casc).addVertex(tol).addVertex(foz)
                .addVertex(fran).addVertex(sao).addVertex(para).addVertex(guara)
                .addVertex(lond).addVertex(ponta).addVertex(marin).addVertex(umu)
                .addVertex(curi);
    }

    private void addLinks() {
        listAdjacency.addLink(l1).addLink(l2).addLink(l3).addLink(l4)
                .addLink(l5).addLink(l6).addLink(l7).addLink(l8).addLink(l9)
                .addLink(l10).addLink(l11).addLink(l12).addLink(l13)
                .addLink(l14);
    }

    public void show() {
        System.out.println(ListAdjacencyViewer.status(listAdjacency));
        System.out.println("\n\n");
        System.out.println(listAdjacency.getHighestDegree());
    }

}
