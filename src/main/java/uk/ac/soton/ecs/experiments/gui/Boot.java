package uk.ac.soton.ecs.experiments.gui;

import uk.ac.soton.ecs.mobilesensors.configuration.Experiment;

public class Boot {

	public static final String LOCAL_GREEDY = "src/main/resources/sensor/new/sensor_greedy.xml";
	public static final String GLOBAL_GREEDY = "src/main/resources/sensor/new/sensor_global_greedy.xml";
	public static final String JUMPING_GREEDY = "src/main/resources/sensor/new/sensor_jumping_greedy.xml";
	public static final String TSP_LARGE_ROOM = "src/main/resources/sensor/new/sensor_tsp_large_room.xml";
	public static final String TSP_B32 = "src/main/resources/sensor/new/sensor_tsp_b32.xml";
	public static final String GLOBAL_RANDOM = "src/main/resources/sensor/new/sensor_global_random.xml";
	public static final String MAX_SUM = "src/main/resources/sensor/new/sensor_max_sum.xml";
	public static final String MAX_SUM_LOCAL = "src/main/resources/sensor/new/sensor_max_sum_local_cluster15.xml";
	public static final String MDP = "src/main/resources/sensor/new/sensor_mdp.xml";
	public static final String HIERARCHICAL_MDP = "src/main/resources/sensor/new/sensor_hierarchical_mdp.xml";

	public static void main(String[] args) throws Exception {
		int i = 3;

		Experiment experiment = new Experiment();
		experiment.setSensorCount(i);
		experiment.setSensorDefinitionFile(MAX_SUM);

		experiment
				.setSimulationDefinitionFile("src/main/resources/simulation/new/b32-disk.xml");

		experiment.setRootOutputDirectory("/tmp/sensor_" + i);

		experiment.initialize();

		new MainFrame(experiment, true);
	}
}
