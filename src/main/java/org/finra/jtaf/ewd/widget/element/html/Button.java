/*
 * (C) Copyright 2013 Java Test Automation Framework Contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.finra.jtaf.ewd.widget.element.html;

import org.finra.jtaf.ewd.widget.IButton;
import org.finra.jtaf.ewd.widget.LocatorType;
import org.finra.jtaf.ewd.widget.WidgetException;
import org.finra.jtaf.ewd.widget.element.InteractiveElement;

/**
 * 
 * Button widget implementation.  Uses Label
 *
 */
public class Button extends InteractiveElement implements IButton {

    /**
     * @param locator
     *           XPath, ID, name, CSS Selector, class name, or tag name string
     */
    public Button(String locator) {
        super(locator);
    }

    /**
     * @param type
     *           XPATH, ID, NAME, CSSSELECTOR, CLASSNAME, or TAGNAME
     * @param locator
     *           XPath, ID, name, CSS Selector, class name, or tag name string
     */
    public Button(LocatorType type, String locator) {
        super(type, locator);
    }

    /*
     * (non-Javadoc)
     * 
     * @see qc.automation.framework.widget.element.InteractiveElement#getLabel()
     */
    @Override
    public String getLabel() throws WidgetException {
        try {
            return getText();
        } catch (Exception e) {
            throw new WidgetException("Error while getting button text", getLocator(), e);
        }
    }
}
