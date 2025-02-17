package soot.jimple.infoflow.solver.gcSolver;

import heros.solver.PathEdge;
import soot.SootMethod;

/**
 * Mock implementation for a garbage collector that does nothing
 * 
 * @author Steven Arzt
 *
 */
public class NullGarbageCollector<N, D> implements IGarbageCollector<N, D> {

	@Override
	public void notifyEdgeSchedule(PathEdge<N, D> edge) {
		// do nothing
	}

	@Override
	public void notifyTaskProcessed(PathEdge<N, D> edge) {
		// do nothing
	}

	@Override
	public void gc() {
		// do nothing
	}

	@Override
	public int getGcedAbstractions() {
		return 0;
	}

	@Override
	public int getGcedEdges() {
		return 0;
	}

	@Override
	public void notifySolverTerminated() {
	}

	public void setPeerGroup(GarbageCollectorPeerGroup<SootMethod> peerGroup) {
		// do nothing.
	}

}
