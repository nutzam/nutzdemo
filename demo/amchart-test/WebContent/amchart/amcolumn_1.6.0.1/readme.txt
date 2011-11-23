amColumn version 1.6.0.0
********************************************************************************
Check documentation for help on all topics:
http://www.amcharts.com/docs/

Incase you don't find something, post your questions to support forum:
http://www.amcharts.com/forum/
********************************************************************************

*** CHANGE LOG *****************************************************************
*** 1.6.0.1 ********************************************************************
Bug with logarithmic scale fixed

*** 1.6.0.0 ********************************************************************

FEATURE ADDED: NEW TYPE - 3D COLUMN

besides clustered, stacked and 100% stacked you can have 3D column now. The 
columns are positioned one behind another. 


FEATURE ADDED: SEQUENCED ANIMATION

if you set <column><sequenced_grow> to "true" the columns will grow one after
another, not all at the same time.


FEATURE ADDED: DARKEN/LIGHTEN COLUMNS ON ROLL-OVER

Using <column><hover_brightness> setting you can make your columns lighter or 
darker when the user roll-overs them. 


FEATURE ADDED: MORE SETTINGS FOR THE BALLOON

New balloon settings allows you to have balloon border and rounded corners:

   <balloon>
     <max_width></max_width>
     <corner_radius></corner_radius>
     <border_width></border_width>  
     <border_alpha></border_alpha>  
     <border_color></border_color>      
   </balloon>
   
FEATURE ADDED: AUTO-FITTING OF THE LEGEND and X AXIS VALUES

The legend now automatically adjusts bottom margin to fit to the flash object's 
area. If your X axis values are rotated, the legend position is adjusted not to
overlap the values. In order this to work, you have to leave <legend><y> setting
empty.


FEATURE ADDED: NEW BULLET TYPES

New bullet types are: square_outline and round_outline


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
gradient_fill_colors attribute from the data file are now accepted.

When adding some settings using additional_chart_settings variable, you don't 
need to set all the <graph> or <label> settings anymore. When 
changing some <label> property using additional_chart_settings, in order to
identify <label>, the labels id (lid) must be added, for example: <label lid="0">



*** 1.5.2.0 ********************************************************************


New feature:
JavaScript function amError(chart_id, error_message) is called when one of the
known errors occurs.

Bug fix: value axis values were shifted to a wrong position when
chart type was "bar", values where displayed inside the chart and left margin 
was small. This is fixed now.



*** 1.5.1.0 ********************************************************************

New feature: the area between every second value axis' grid can be filled with
color. The color is defined at: <grid><value><fill_color>. Fill alpha can be
defined at <grid><value><fill_alpha>

Bug fix: When reloading settings with reloadSettings() function, if settings
file contained data, the data wasn't refreshed. This is fixed in this version.
********************************************************************************