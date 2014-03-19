#version 120
float alpha = 0.2;

vec3 color = vec3(0.1, 0.1, 0.1);
 
void main() 
{
	gl_FragColor = vec4(color.rgb, alpha);
}