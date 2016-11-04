import org.gephi.appearance.api.Ranking;
import org.gephi.appearance.spi.Transformer;
import org.gephi.filters.api.FilterController;
import org.gephi.filters.api.Query;
import org.gephi.filters.api.Range;
import org.gephi.filters.plugin.graph.DegreeRangeBuilder;
import org.gephi.graph.api.*;
import org.gephi.io.importer.api.Container;
import org.gephi.io.importer.api.ImportController;
import org.gephi.io.importer.plugin.database.ImporterEdgeList;
import org.gephi.io.processor.plugin.DefaultProcessor;
import org.gephi.layout.plugin.force.StepDisplacement;
import org.gephi.layout.plugin.force.yifanHu.YifanHuLayout;
import org.gephi.preview.api.PreviewController;
import org.gephi.preview.api.PreviewModel;
import org.gephi.preview.api.PreviewProperty;
import org.gephi.preview.api.RenderTarget;
import org.gephi.preview.types.EdgeColor;
import org.gephi.project.api.ProjectController;
import org.gephi.project.api.Workspace;
import org.gephi.statistics.plugin.GraphDistance;
import org.openide.filesystems.annotations.LayerBuilder;
import org.openide.util.Lookup;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by bczhang on 2016/6/20.
 */
public class TestGephi {

//    public void run(){
//    //Init a project - and therefore a workspace
//    ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
//    pc.newProject();
//    Workspace workspace = pc.getCurrentWorkspace();
//
//    //Get models and controllers for this new workspace - will be useful later
//    AttributeModel attributeModel = Lookup.getDefault().lookup(AttributeController.class).getModel();
//    GraphModel graphModel = Lookup.getDefault().lookup(GraphController.class).getModel();
//    PreviewModel model = Lookup.getDefault().lookup(PreviewController.class).getModel();
//    ImportController importController = Lookup.getDefault().lookup(ImportController.class);
//    FilterController filterController = Lookup.getDefault().lookup(FilterController.class);
//    RankingController rankingController = Lookup.getDefault().lookup(RankingController.class);
//
//
//    //Import file
//    Container container;
//    try {
//        File file = new File(getClass().getResource("/org/gephi/toolkit/demos/resources/polblogs.gml").toURI());
//        container = importController.importFile(file);
//        container.getLoader().setEdgeDefault(EdgeDefault.DIRECTED);   //Force DIRECTED
//    } catch (Exception ex) {
//        ex.printStackTrace();
//        return;
//    }
////Append imported data to GraphAPI
//    importController.process(container, new DefaultProcessor(), workspace);
//
//    //See if graph is well imported
//    DirectedGraph graph = graphModel.getDirectedGraph();
//    System.out.println("Nodes: " + graph.getNodeCount());
//    System.out.println("Edges: " + graph.getEdgeCount());
//
//    //Filter
//    DegreeRangeBuilder.DegreeRangeFilter degreeFilter = new DegreeRangeBuilder.DegreeRangeFilter();
//    degreeFilter.init(graph);
//    degreeFilter.setRange(new Range(30, Integer.MAX_VALUE));     //Remove nodes with degree < 30
//    Query query = filterController.createQuery(degreeFilter);
//    GraphView view = filterController.filter(query);
//    graphModel.setVisibleView(view);    //Set the filter result as the visible view
//
//    //See visible graph stats
//    UndirectedGraph graphVisible = graphModel.getUndirectedGraphVisible();
//    System.out.println("Nodes: " + graphVisible.getNodeCount());
//    System.out.println("Edges: " + graphVisible.getEdgeCount());
//    //Run YifanHuLayout for 100 passes - The layout always takes the current visible view
//    YifanHuLayout layout = new YifanHuLayout(null, new StepDisplacement(1f));
//    layout.setGraphModel(graphModel);
//    layout.resetPropertiesValues();
//    layout.setOptimalDistance(200f);
//    layout.initAlgo();
//
//    for (int i = 0; i < 100 && layout.canAlgo(); i++) {
//        layout.goAlgo();
//    }
//    layout.endAlgo();
//
//    //Rank color by Degree
//    Ranking degreeRanking = rankingController.getModel().getRanking(Ranking.NODE_ELEMENT, Ranking.DEGREE_RANKING);
//    AbstractColorTransformer colorTransformer = (AbstractColorTransformer) rankingController.getModel().getTransformer(Ranking.NODE_ELEMENT, Transformer.RENDERABLE_COLOR);
//    colorTransformer.setColors(new Color[]{new Color(0xFEF0D9), new Color(0xB30000)});
//    rankingController.transform(degreeRanking,colorTransformer);
//
//    //Rank size by centrality
//    AttributeColumn centralityColumn = attributeModel.getNodeTable().getColumn(GraphDistance.BETWEENNESS);
//    Ranking centralityRanking = rankingController.getModel().getRanking(Ranking.NODE_ELEMENT, centralityColumn.getId());
//    AbstractSizeTransformer sizeTransformer = (AbstractSizeTransformer) rankingController.getModel().getTransformer(Ranking.NODE_ELEMENT, Transformer.RENDERABLE_SIZE);
//    sizeTransformer.setMinSize(3);
//    sizeTransformer.setMaxSize(10);
//    rankingController.transform(centralityRanking,sizeTransformer);
//
//    //Preview
//    PreviewController previewController = Lookup.getDefault().lookup(PreviewController.class);
//    model.getProperties().putValue(PreviewProperty.SHOW_NODE_LABELS, Boolean.TRUE);
//    model.getProperties().putValue(PreviewProperty.EDGE_COLOR, new EdgeColor(Color.GRAY));
//    model.getProperties().putValue(PreviewProperty.EDGE_THICKNESS, new Float(0.1f));
//    model.getProperties().putValue(PreviewProperty.NODE_LABEL_FONT, model.getProperties().getFontValue(PreviewProperty.NODE_LABEL_FONT).deriveFont(8));
//    previewController.refreshPreview();
//
//    //New Processing target, get the PApplet
//    ProcessingTarget target = (ProcessingTarget) previewController.getRenderTarget(RenderTarget.PROCESSING_TARGET);
//    PApplet applet = target.getApplet();
//    applet.init();
//
////Refresh the preview and reset the zoom
//    previewController.render(target);
//    target.refresh();
//    target.resetZoom();
//
//    //Add the applet to a JFrame and display
//    JFrame frame = new JFrame("Test Preview");
//    frame.setLayout(new BorderLayout());
//
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.add(applet, BorderLayout.CENTER);
//
//    frame.pack();
//    frame.setVisible(true);
//}

//    public void test(){
//        //Init a project - and therefore a workspace
//        ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
//        pc.newProject();
//        Workspace workspace = pc.getCurrentWorkspace();
//        //Import file
//        ImportController importController = Lookup.getDefault().lookup(ImportController.class);
//        Container container;
//        try {
//            File file = new File(getClass().getResource("/org/gephi/toolkit/demos/resources/test.gexf").toURI());
//            container = importController.importFile(file);
//            container.getLoader().setEdgeDefault(EdgeDefault.DIRECTED); //Force DIRECTED
//            container.setAllowAutoNode(false); //Don’t create missing nodes
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return;
//        }
////Append imported data to GraphAPI
//        importController.process(container, new DefaultProcessor(), workspace);
//        //Get a graph model - it exists because we have a workspace
//        GraphModel graphModel = Lookup.getDefault().lookup(GraphController.class).getModel();
////Create two nodes
//        Node n0 = graphModel.factory().newNode("n0");
//        n0.getNodeData().setLabel("Node 0");
//        Node n1 = graphModel.factory().newNode("n1");
//        n1.getNodeData().setLabel("Node 1");
////Create an edge - directed and weight 1
//        Edge e1 = graphModel.factory().newEdge(n1, n0, 1, true);
////Append as a Directed Graph
//        DirectedGraph directedGraph = graphModel.getDirectedGraph();
//        directedGraph.addNode(n0);
//        directedGraph.addNode(n1);
//        directedGraph.addEdge(e1);
//        //Count nodes and edges
//        System.out.println("Nodes: "+directedGraph.getNodeCount()+" Edges: "+directedGraph.getEdgeCount());
////Iterate over nodes
//        for(Node n : directedGraph.getNodes()) {
//            Node[] neighbors = directedGraph.getNeighbors(n).toArray();
//            System.out.println(n.getNodeData().getLabel()+" has "+neighbors.length+" neighbors");
//        }
////Find node by id
//        Node node2 = directedGraph.getNode("n2");
////Modify the graph while reading
////Due to locking, you need to use toArray() on Iterable to be able to modify the graph in a read loop
//        for(Node n : directedGraph.getNodes().toArray()) {
//            directedGraph.removeNode(n);
//        }
//
}
