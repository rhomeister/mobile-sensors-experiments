package uk.ac.soton.ecs.experiments.gui;

import uk.ac.soton.ecs.mobilesensors.Simulation;
import uk.ac.soton.ecs.mobilesensors.SimulationEventListener;
import uk.ac.soton.ecs.mobilesensors.configuration.Experiment;
import uk.ac.soton.ecs.mobilesensors.sensor.Sensor;
import uk.ac.soton.ecs.mobilesensors.sensor.SensorID;
import uk.ac.soton.ecs.mobilesensors.sensor.coordination.CentralisedCoordinationMechanism;
import uk.ac.soton.ecs.mobilesensors.sensor.coordination.centralised.MDPCentralisedHierarchicalController;

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
		int i = 1;

		Experiment experiment = new Experiment();
		experiment.setSensorCount(i);
		experiment.setSensorDefinitionFile(HIERARCHICAL_MDP);

		System.err.println(experiment.getSensorDefinitionFile());
		// experiment.setSensorDefinitionFile(MAX_SUM_LOCAL);

		// experiment
		// .setSimulationDefinitionFile("src/main/resources/simulation/new/b32-patrolling.xml");

		// experiment
		// .setSimulationDefinitionFile("src/main/resources/simulation/new/large-room-probabilistic_pursuit.xml");

		// experiment
		// .setSimulationDefinitionFile("src/main/resources/simulation/new/b32-probabilistic_pursuit.xml");

		// experiment
		// .setSimulationDefinitionFile("src/main/resources/simulation/new/2rooms-disk.xml");
		experiment
				.setSimulationDefinitionFile("src/main/resources/simulation/new/b32-disk.xml");

		experiment.setRootOutputDirectory("/tmp/sensor_" + i);

		experiment.initialize();

		experiment.getSimulation().addEventListener(
				new SimulationEventListener() {

					private MDPCentralisedHierarchicalController controller;

					public void handleStartOfSimulation(Simulation source,
							double time) {
						Sensor sensor = source.getSensorByID(new SensorID(0));
						CentralisedCoordinationMechanism coordinationMechanism = (CentralisedCoordinationMechanism) sensor
								.getCoordinationMechanism();
						if (coordinationMechanism.getController() instanceof MDPCentralisedHierarchicalController) {
							controller = (MDPCentralisedHierarchicalController) coordinationMechanism
									.getController();
						}
					}

					public void handleStartOfRound(Simulation source,
							int round, double timestep) {

					}

					public void handleEndOfSimulation(Simulation source)
							throws Exception {

					}

					public void handleEndOfRound(Simulation source, int round,
							double timestep) {

						// if (round == 50) {
						// source.getSensorByID(new SensorID(0)).fail();
						// // source.getSensorByID(new SensorID(1)).fail();
						// }

						// if (round == 80) {
						// controller.repairBrokenSensors();
						// }

					}
				});

		// experiment.run();

		new MainFrame(experiment, true);
	}
}
