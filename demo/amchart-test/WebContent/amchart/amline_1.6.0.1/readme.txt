amline version 1.6.0.0
********************************************************************************
Check documentation for help on all topics:
http://www.amcharts.com/docs/

Incase you don't find something, post your questions to support forum:
http://www.amcharts.com/forum/

*** CHANGE LOG *****************************************************************
*** 1.6.0.0 ********************************************************************


FEATURE ADDED: RESCALING THE CHART WHEN THE GRAPH IS HIDDEN
When you click on the legend key, the graph is hidden or shown. Now the chart
recalculates min and max values (rescales the chart) when you do this. You can
turn this feature off by setting <rescale_on_hide> to "false".


FEATURE ADDED: AUTO-FITTING OF THE LEGEND and X AXIS VALUES

The legend now automatically adjusts bottom margin to fit to the flash object's 
area. If your X axis values are rotated, the legend position is adjusted not to
overlap the values. In order this to work, you have to leave <legend><y> setting
empty.


FEATURE ADDED: Y BALLOONS NO LONGER OVERLAP


FEATURE ADDED: NEW BULLET TYPES

New bullet types are: square_outline and round_outline


FEATURE ADDED: CHART TYPE CAN BE SET SEPARATELY FOR RIGHT AND LEFT AXES

Previously you set the same <type> (line, stacked, 100% stacked) for both
left and right axes. Now you can set the type separately. This setting is now 
in <axes> section.


FEATURE ADDED: MORE SETTINGS FOR THE Y BALLOON

New balloon settings allows you to have balloon border and rounded corners:

   <balloon>
      <only_one></only_one>
      <on_off></on_off>
      <color></color>          
      <alpha></alpha>          
      <text_color></text_color>
      <text_size></text_size>  
      <max_width></max_width>  
      <corner_radius></corner_radius>
      <border_width></border_width>  
      <border_alpha></border_alpha>  
      <border_color></border_color>    
   </balloon> 
   
The <only_one> setting replaced the <indicator><one_y_balloon> setting, and the
<on_off></on_off> replaced the <indicator><y_balloon_on_off>. The old ones will
also work.


FEATURE ADDED: POSSIBILITY TO SET ARRAY OF COLORS

Using <colors></colors> setting, you can set an array fo colors, which will
be used if the graph's color is not set.


FEATURE ADDED: CHANGE MULTIPLE SETTINGS WITH JAVASCRIPT

Using new function, flashMovie.setSettings(settings, rebuild) You can control
multiple settings.  It is recommended to use this new function even for one 
setting, instead of setParam() function. The "rebuild" option might be "true" 
or "false" (the default is "true"). If you set it to "false", then the settings
will not be applied until you call another new JS function: flashMovie.rebuild()
or pass another set of settings with the "rebuild" set to "true". 

A new function flashMovie.getSettings() will return the full settings 
XML by calling amReturnSettings(chart_id, settings) function. 


FEATURE ADDED: IMAGE DATA IS PASSED TO JAVASCRIPT

When exporting chart as an image, the chart passes image data to JavaScript 
function: amReturnImageData(chart_id, data) 


FEATURE ADDED: FONT COLOR AND SIZE OF A LABEL TEXT

<labels> Can accept  font color and font size HTML tags now, for example:
<text><![CDATA[Source: <font color="#CC0000" size="14">amCharts</font>]]></text>


CHANGE OF THE DEFAULT SETTINGS:
<context_menu><default_items><zoom> default value was changed to "false"


FIXES:
When adding some settings using additional_chart_settings variable, you don't 
need to set all the <graph> or <label> settings anymore. When 
changing some <label> property using additional_chart_settings, in order to
identify <label>, the labels id (lid) must be added, for example: <label lid="0">

When <connect> is set to true, and there are values missing, the chart shows
full line when zoomed.

"aditional_chart_settings" variable can accept multiple guides now.

min / max calculation bug with stacked chart type fixed.



*** 1.5.2.0 ********************************************************************


New features:

JavaScript function amError(chart_id, error_message) is called when one of the
known errors occurs.

New JavaScript function for showing/hiding and selecting/deselecting graphs 
added:

flashMovie.showGraph(index)
flashMovie.hideGraph(index)
flashMovie.selectGraph(index)
flashMovie.deselectGraph(index)

You can also use these functions in case you load chart to another swf movie.



*** 1.5.1.0 ********************************************************************


New feature: the area between every second y axis grid can be filled with
color. The color is defined at: <grid><y_left><fill_color>. Fill alpha can be
defined at <grid><y_left><fill_alpha>

Bug fix: When reloading settings with reloadSettings() function, if settings
file contained data, the data wasn't refreshed. This is fixed in this version.
********************************************************************************