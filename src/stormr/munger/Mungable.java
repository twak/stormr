/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stormr.munger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author twak
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Mungable
{
    public String methods() default "";
    public String fields() default "";
}
