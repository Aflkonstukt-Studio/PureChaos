#version 150

uniform sampler2D DiffuseSampler;
uniform vec4 ColorModulate;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    // Sample the texture at the given coordinates
    vec4 color = texture(DiffuseSampler, texCoord);

    // Convert the color to grayscale (desaturate)
    float gray = dot(color.rgb, vec3(0.3, 0.59, 0.11));

    // Adjust the saturation by blending the grayscale with the original color
    // Increase the factor for more saturation
    vec3 paleColor = mix(vec3(gray), color.rgb, 0.4);  // Change 0.5 to a higher value for more saturation

    // Apply the color modulation and set the final color
    fragColor = vec4(paleColor, color.a) * ColorModulate;
}