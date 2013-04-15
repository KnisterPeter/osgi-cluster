package de.matrixweb.osgi.cluster.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import de.matrixweb.osgi.cluster.ClusterManager;

/**
 * @author markusw
 */
public class Activator implements BundleActivator {

  private ClusterManagerImpl manager;

  private ServiceRegistration<ClusterManager> service;

  /**
   * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(final BundleContext context) throws Exception {
    this.manager = new ClusterManagerImpl();
    this.service = context.registerService(ClusterManager.class, this.manager,
        null);
  }

  /**
   * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(final BundleContext context) {
    if (this.service != null) {
      this.service.unregister();
      this.service = null;
    }
    if (this.manager != null) {
      this.manager.dispose();
      this.manager = null;
    }
  }

}
