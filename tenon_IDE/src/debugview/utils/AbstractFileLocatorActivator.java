package debugview.utils;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStream; 
import java.net.URISyntaxException; 
import java.net.URL; 
import java.util.Collections; 
 
import org.eclipse.core.runtime.FileLocator; 
import org.eclipse.core.runtime.Path; 
import org.eclipse.ui.plugin.AbstractUIPlugin; 
import org.osgi.framework.Bundle; 
 
public abstract class AbstractFileLocatorActivator extends AbstractUIPlugin { 
 
    /**
     * @param path 
     *            The path to the file relative to this plugin's root 
     * @param bundle 
     *            The bundle containing information as to where is this plugin 
     * @return An Inputstream to the file or null if the activator is not set or could not find the 
     *         file (this is not a regular RCP run... happens for tests) 
     * @throws IOException 
     *             Thrown if there is an error while reading the file 
     */ 
    public static InputStream locateFile (String path, Bundle bundle) throws IOException { 
 
        File file = resolveFile(path, bundle); 
        if (file != null) { 
            return new FileInputStream(file); 
        } 
        return null; 
    } 
 
    /**
     * @param path 
     *            The path to the file relative to this plugin's root 
     * @param bundle 
     *            The bundle containing information as to where is this plugin 
     * @return A File pointing to the system file or null if the activator is not set or could not 
     *         find the file (this is not a regular RCP run... happens for non-plugins tests) 
     * @throws IOException 
     *             Thrown if there is an error while reading the file 
     */ 
    public static File resolveFile (String path, Bundle bundle) throws IOException { 
 
        File file = null; 
        if (bundle != null) { 
            URL url = FileLocator.find(bundle, new Path(path), Collections.emptyMap()); 
            if (url != null) { 
                URL fileUrl = FileLocator.toFileURL(url); 
                try { 
                    file = new File(fileUrl.toURI()); 
                } 
                catch (URISyntaxException e) { 
                    e.printStackTrace(); 
                } 
            } 
        } 
        return file; 
    } 
}
