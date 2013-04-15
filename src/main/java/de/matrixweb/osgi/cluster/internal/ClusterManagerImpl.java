package de.matrixweb.osgi.cluster.internal;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

import de.matrixweb.osgi.cluster.ClusterManager;

/**
 * @author markusw
 */
public class ClusterManagerImpl extends ReceiverAdapter implements
    ClusterManager {

  private final JChannel channel;

  /**
   * @throws Exception
   */
  ClusterManagerImpl() throws Exception {
    this.channel = new JChannel();
    this.channel.connect("osgi-kernel-cluster");
  }

  /**
   * @see org.jgroups.ReceiverAdapter#viewAccepted(org.jgroups.View)
   */
  @Override
  public void viewAccepted(final View view) {
    System.out.println("ClusterManagerImpl.viewAccepted()");
    System.out.println(view);
  }

  /**
   * @see org.jgroups.ReceiverAdapter#receive(org.jgroups.Message)
   */
  @Override
  public void receive(final Message msg) {
    System.out.println("ClusterManagerImpl.receive()");
    System.out.println(msg);
  }

  /**
   * 
   */
  void dispose() {
    this.channel.close();
  }

}
