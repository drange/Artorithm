package com.sessility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ColorLibrary {

  private final static Random RANDOM = new Random();

  private static final Map<String, NamedColor> COLOR_LIBRARY = new HashMap<>();

  public static void populateColors() {
    if (!COLOR_LIBRARY.isEmpty()) {
      throw new IllegalStateException("Color library already populated");
    }
    put("indian red", 176, 23, 31);
    put("crimson", 220, 20, 60);
    put("lightpink", 255, 182, 193);
    put("lightpink 1", 255, 174, 185);
    put("lightpink 2", 238, 162, 173);
    put("lightpink 3", 205, 140, 149);
    put("lightpink 4", 139, 95, 101);
    put("pink", 255, 192, 203);
    put("pink 1", 255, 181, 197);
    put("pink 2", 238, 169, 184);
    put("pink 3", 205, 145, 158);
    put("pink 4", 139, 99, 108);
    put("palevioletred", 219, 112, 147);
    put("palevioletred 1", 255, 130, 171);
    put("palevioletred 2", 238, 121, 159);
    put("palevioletred 3", 205, 104, 137);
    put("palevioletred 4", 139, 71, 93);
    put("lavenderblush 1", 255, 240, 245);
    put("lavenderblush 2", 238, 224, 229);
    put("lavenderblush 3", 205, 193, 197);
    put("lavenderblush 4", 139, 131, 134);
    put("violetred 1", 255, 62, 150);
    put("violetred 2", 238, 58, 140);
    put("violetred 3", 205, 50, 120);
    put("violetred 4", 139, 34, 82);
    put("hotpink", 255, 105, 180);
    put("hotpink 1", 255, 110, 180);
    put("hotpink 2", 238, 106, 167);
    put("hotpink 3", 205, 96, 144);
    put("hotpink 4", 139, 58, 98);
    put("raspberry", 135, 38, 87);
    put("deeppink 1", 255, 20, 147);
    put("deeppink 2", 238, 18, 137);
    put("deeppink 3", 205, 16, 118);
    put("deeppink 4", 139, 10, 80);
    put("maroon 1", 255, 52, 179);
    put("maroon 2", 238, 48, 167);
    put("maroon 3", 205, 41, 144);
    put("maroon 4", 139, 28, 98);
    put("mediumvioletred", 199, 21, 133);
    put("violetred", 208, 32, 144);
    put("orchid", 218, 112, 214);
    put("orchid 1", 255, 131, 250);
    put("orchid 2", 238, 122, 233);
    put("orchid 3", 205, 105, 201);
    put("orchid 4", 139, 71, 137);
    put("thistle", 216, 191, 216);
    put("thistle 1", 255, 225, 255);
    put("thistle 2", 238, 210, 238);
    put("thistle 3", 205, 181, 205);
    put("thistle 4", 139, 123, 139);
    put("plum 1", 255, 187, 255);
    put("plum 2", 238, 174, 238);
    put("plum 3", 205, 150, 205);
    put("plum 4", 139, 102, 139);
    put("plum", 221, 160, 221);
    put("violet", 238, 130, 238);
    put("magenta", 255, 0, 255);
    put("magenta 2 ", 238, 0, 238);
    put("magenta 3", 205, 02, 05);
    put("magenta 4", 139, 0, 139);
    put("purple*", 128, 0, 128);
    put("mediumorchid", 186, 85, 211);
    put("mediumorchid 1", 224, 102, 255);
    put("mediumorchid 2", 209, 95, 238);
    put("mediumorchid 3", 180, 82, 205);
    put("mediumorchid 4", 122, 55, 139);
    put("darkviolet", 148, 0, 211);
    put("darkorchid", 153, 50, 204);
    put("darkorchid 1", 191, 62, 255);
    put("darkorchid 2", 178, 58, 238);
    put("darkorchid 3", 154, 50, 205);
    put("darkorchid 4", 104, 34, 139);
    put("indigo", 75, 0, 130);
    put("blueviolet", 138, 43, 226);
    put("purple 1", 155, 48, 255);
    put("purple 2", 145, 44, 238);
    put("purple 3", 125, 38, 205);
    put("purple 4", 85, 26, 139);
    put("mediumpurple", 147, 112, 219);
    put("mediumpurple 1", 171, 130, 255);
    put("mediumpurple 2", 159, 121, 238);
    put("mediumpurple 3", 137, 104, 205);
    put("mediumpurple 4", 93, 71, 139);
    put("darkslateblue", 72, 61, 139);
    put("lightslateblue", 132, 112, 255);
    put("mediumslateblue", 123, 104, 238);
    put("slateblue", 106, 90, 205);
    put("slateblue 1", 131, 111, 255);
    put("slateblue 2", 122, 103, 238);
    put("slateblue 3", 105, 89, 205);
    put("slateblue 4", 71, 60, 139);
    put("ghostwhite", 248, 248, 255);
    put("lavender", 230, 230, 250);
    put("blue*", 0, 0, 255);
    put("blue 2", 0, 0, 238);
    put("blue 3", 0, 0, 205);
    put("blue 4", 0, 0, 139);
    put("navy*", 0, 0, 128);
    put("midnightblue", 25, 25, 112);
    put("cobalt", 61, 89, 171);
    put("royalblue", 65, 105, 225);
    put("royalblue 1", 72, 118, 255);
    put("royalblue 2", 67, 110, 238);
    put("royalblue 3", 58, 95, 205);
    put("royalblue 4", 39, 64, 139);
    put("cornflowerblue", 100, 149, 237);
    put("lightsteelblue", 176, 196, 222);
    put("lightsteelblue 1", 202, 225, 255);
    put("lightsteelblue 2", 188, 210, 238);
    put("lightsteelblue 3", 162, 181, 205);
    put("lightsteelblue 4", 110, 123, 139);
    put("lightslategray", 119, 136, 153);
    put("slategray", 112, 128, 144);
    put("slategray 1", 198, 226, 255);
    put("slategray 2", 185, 211, 238);
    put("slategray 3", 159, 182, 205);
    put("slategray 4", 108, 123, 139);
    put("dodgerblue 1", 30, 144, 255);
    put("dodgerblue 2", 28, 134, 238);
    put("dodgerblue 3", 24, 116, 205);
    put("dodgerblue 4", 16, 78, 139);
    put("aliceblue", 240, 248, 255);
    put("steelblue", 70, 130, 180);
    put("steelblue 1", 99, 184, 255);
    put("steelblue 2", 92, 172, 238);
    put("steelblue 3", 79, 148, 205);
    put("steelblue 4", 54, 100, 139);
    put("lightskyblue", 135, 206, 250);
    put("lightskyblue 1", 176, 226, 255);
    put("lightskyblue 2", 164, 211, 238);
    put("lightskyblue 3", 141, 182, 205);
    put("lightskyblue 4", 96, 123, 139);
    put("skyblue 1", 135, 206, 255);
    put("skyblue 2", 126, 192, 238);
    put("skyblue 3", 108, 166, 205);
    put("skyblue 4", 74, 112, 139);
    put("skyblue", 135, 206, 235);
    put("deepskyblue 1", 0, 191, 255);
    put("deepskyblue 2", 0, 178, 238);
    put("deepskyblue 3", 0, 154, 205);
    put("deepskyblue 4", 0, 104, 139);
    put("peacock", 51, 161, 201);
    put("lightblue", 173, 216, 230);
    put("lightblue 1", 191, 239, 255);
    put("lightblue 2", 178, 223, 238);
    put("lightblue 3", 154, 192, 205);
    put("lightblue 4", 104, 131, 139);
    put("powderblue", 176, 224, 230);
    put("cadetblue 1", 152, 245, 255);
    put("cadetblue 2", 142, 229, 238);
    put("cadetblue 3", 122, 197, 205);
    put("cadetblue 4", 83, 134, 139);
    put("turquoise 1", 0, 245, 255);
    put("turquoise 2", 0, 229, 238);
    put("turquoise 3", 0, 197, 205);
    put("turquoise 4", 0, 134, 139);
    put("cadetblue", 95, 158, 160);
    put("darkturquoise", 0, 206, 209);
    put("azure 1", 240, 255, 255);
    put("azure 2", 224, 238, 238);
    put("azure 3", 193, 205, 205);
    put("azure 4", 131, 139, 139);
    put("lightcyan 1", 224, 255, 255);
    put("lightcyan 2", 209, 238, 238);
    put("lightcyan 3", 180, 205, 205);
    put("lightcyan 4", 122, 139, 139);
    put("paleturquoise 1", 187, 255, 255);
    put("paleturquoise 2", 174, 238, 238);
    put("paleturquoise 3", 150, 205, 205);
    put("paleturquoise 4", 102, 139, 139);
    put("darkslategray", 47, 79, 79);
    put("darkslategray 1", 151, 255, 255);
    put("darkslategray 2", 141, 238, 238);
    put("darkslategray 3", 121, 205, 205);
    put("darkslategray 4", 82, 139, 139);
    put("cyan / aqua*", 0, 255, 255);
    put("cyan 2", 0, 238, 238);
    put("cyan 3", 0, 205, 205);
    put("cyan 4", 0, 139, 139);
    put("teal*", 0, 128, 128);
    put("mediumturquoise", 72, 209, 204);
    put("lightseagreen", 32, 178, 170);
    put("manganeseblue", 3, 168, 158);
    put("turquoise", 64, 224, 208);
    put("coldgrey", 128, 138, 135);
    put("turquoiseblue", 0, 199, 140);
    put("aquamarine 1", 127, 255, 212);
    put("aquamarine 2", 118, 238, 198);
    put("aquamarine 3", 102, 205, 170);
    put("aquamarine 4", 69, 139, 116);
    put("mediumspringgreen", 0, 250, 154);
    put("mintcream", 245, 255, 250);
    put("springgreen", 0, 255, 127);
    put("springgreen 1", 0, 238, 118);
    put("springgreen 2", 0, 205, 102);
    put("springgreen 3", 0, 139, 69);
    put("mediumseagreen", 60, 179, 113);
    put("seagreen 1", 84, 255, 159);
    put("seagreen 2", 78, 238, 148);
    put("seagreen 3", 67, 205, 128);
    put("seagreen 4", 46, 139, 87);
    put("emeraldgreen", 0, 201, 87);
    put("mint", 189, 252, 201);
    put("cobaltgreen", 61, 145, 64);
    put("honeydew 1", 240, 255, 240);
    put("honeydew 2", 224, 238, 224);
    put("honeydew 3", 193, 205, 193);
    put("honeydew 4", 131, 139, 131);
    put("darkseagreen", 143, 188, 143);
    put("darkseagreen 1", 193, 255, 193);
    put("darkseagreen 2", 180, 238, 180);
    put("darkseagreen 3", 155, 205, 155);
    put("darkseagreen 4", 105, 139, 105);
    put("palegreen", 152, 251, 152);
    put("palegreen 1", 154, 255, 154);
    put("palegreen 2", 144, 238, 144);
    put("palegreen 3", 124, 205, 124);
    put("palegreen 4", 84, 139, 84);
    put("limegreen", 50, 205, 50);
    put("forestgreen", 34, 139, 34);
    put("green 1", 0, 255, 0);
    put("green 2", 0, 238, 0);
    put("green 3", 0, 205, 0);
    put("green 4", 0, 139, 0);
    put("green*", 0, 128, 0);
    put("darkgreen", 0, 100, 0);
    put("sapgreen", 48, 128, 20);
    put("lawngreen", 124, 252, 0);
    put("chartreuse 1", 127, 255, 0);
    put("chartreuse 2", 118, 238, 0);
    put("chartreuse 3", 102, 205, 0);
    put("chartreuse 4", 69, 139, 0);
    put("greenyellow", 173, 255, 47);
    put("darkolivegreen 1", 202, 255, 112);
    put("darkolivegreen 2", 188, 238, 104);
    put("darkolivegreen 3", 162, 205, 90);
    put("darkolivegreen 4", 110, 139, 61);
    put("darkolivegreen", 85, 107, 47);
    put("olivedrab", 107, 142, 35);
    put("olivedrab 1", 192, 255, 62);
    put("olivedrab 2", 179, 238, 58);
    put("olivedrab 3", 154, 205, 50);
    put("olivedrab 4", 105, 139, 34);
    put("ivory 1", 255, 255, 240);
    put("ivory 2", 238, 238, 224);
    put("ivory 3", 205, 205, 193);
    put("ivory 4", 139, 139, 131);
    put("beige", 245, 245, 220);
    put("lightyellow 1", 255, 255, 224);
    put("lightyellow 2", 238, 238, 209);
    put("lightyellow 3", 205, 205, 180);
    put("lightyellow 4", 139, 139, 122);
    put("lightgoldenrodyellow", 250, 250, 210);
    put("yellow 1", 255, 255, 0);
    put("yellow 2", 238, 238, 0);
    put("yellow 3", 205, 205, 0);
    put("yellow 4", 139, 139, 0);
    put("warmgrey", 128, 128, 105);
    put("olive*", 128, 128, 0);
    put("darkkhaki", 189, 183, 107);
    put("khaki 1", 255, 246, 143);
    put("khaki 2", 238, 230, 133);
    put("khaki 3", 205, 198, 115);
    put("khaki 4", 139, 134, 78);
    put("khaki", 240, 230, 140);
    put("palegoldenrod", 238, 232, 170);
    put("lemonchiffon 1", 255, 250, 205);
    put("lemonchiffon 2", 238, 233, 191);
    put("lemonchiffon 3", 205, 201, 165);
    put("lemonchiffon 4", 139, 137, 112);
    put("lightgoldenrod 1", 255, 236, 139);
    put("lightgoldenrod 2", 238, 220, 130);
    put("lightgoldenrod 3", 205, 190, 112);
    put("lightgoldenrod 4", 139, 129, 76);
    put("banana", 227, 207, 87);
    put("gold 1", 255, 215, 0);
    put("gold 2", 238, 201, 0);
    put("gold 3", 205, 173, 0);
    put("gold 4", 139, 117, 0);
    put("cornsilk 1", 255, 248, 220);
    put("cornsilk 2", 238, 232, 205);
    put("cornsilk 3", 205, 200, 177);
    put("cornsilk 4", 139, 136, 120);
    put("goldenrod", 218, 165, 32);
    put("goldenrod 1", 255, 193, 37);
    put("goldenrod 2", 238, 180, 34);
    put("goldenrod 3", 205, 155, 29);
    put("goldenrod 4", 139, 105, 20);
    put("darkgoldenrod", 184, 134, 11);
    put("darkgoldenrod 1", 255, 185, 15);
    put("darkgoldenrod 2", 238, 173, 14);
    put("darkgoldenrod 3", 205, 149, 12);
    put("darkgoldenrod 4", 139, 101, 8);
    put("orange 1", 255, 165, 0);
    put("orange 2", 238, 154, 0);
    put("orange 3", 205, 133, 0);
    put("orange 4", 139, 90, 0);
    put("floralwhite", 255, 250, 240);
    put("oldlace", 253, 245, 230);
    put("wheat", 245, 222, 179);
    put("wheat 1", 255, 231, 186);
    put("wheat 2", 238, 216, 174);
    put("wheat 3", 205, 186, 150);
    put("wheat 4", 139, 126, 102);
    put("moccasin", 255, 228, 181);
    put("papayawhip", 255, 239, 213);
    put("blanchedalmond", 255, 235, 205);
    put("navajowhite 1", 255, 222, 173);
    put("navajowhite 2", 238, 207, 161);
    put("navajowhite 3", 205, 179, 139);
    put("navajowhite 4", 139, 121, 94);
    put("eggshell", 252, 230, 201);
    put("tan", 210, 180, 140);
    put("brick", 156, 102, 31);
    put("cadmiumyellow", 255, 153, 18);
    put("antiquewhite", 250, 235, 215);
    put("antiquewhite 1", 255, 239, 219);
    put("antiquewhite 2", 238, 223, 204);
    put("antiquewhite 3", 205, 192, 176);
    put("antiquewhite 4", 139, 131, 120);
    put("burlywood", 222, 184, 135);
    put("burlywood 1", 255, 211, 155);
    put("burlywood 2", 238, 197, 145);
    put("burlywood 3", 205, 170, 125);
    put("burlywood 4", 139, 115, 85);
    put("bisque 1", 255, 228, 196);
    put("bisque 2", 238, 213, 183);
    put("bisque 3", 205, 183, 158);
    put("bisque 4", 139, 125, 107);
    put("melon", 227, 168, 105);
    put("carrot", 237, 145, 33);
    put("darkorange", 255, 140, 0);
    put("darkorange 1", 255, 127, 0);
    put("darkorange 2", 238, 118, 0);
    put("darkorange 3", 205, 102, 0);
    put("darkorange 4", 139, 69, 0);
    put("orange", 255, 128, 0);
    put("tan 1", 255, 165, 79);
    put("tan 2", 238, 154, 73);
    put("tan 3", 205, 133, 63);
    put("tan 4", 139, 90, 43);
    put("linen", 250, 240, 230);
    put("peachpuff 1", 255, 218, 185);
    put("peachpuff 2", 238, 203, 173);
    put("peachpuff 3", 205, 175, 149);
    put("peachpuff 4", 139, 119, 101);
    put("seashell 1", 255, 245, 238);
    put("seashell 2", 238, 229, 222);
    put("seashell 3", 205, 197, 191);
    put("seashell 4", 139, 134, 130);
    put("sandybrown", 244, 164, 96);
    put("rawsienna", 199, 97, 20);
    put("chocolate", 210, 105, 30);
    put("chocolate 1", 255, 127, 36);
    put("chocolate 2", 238, 118, 33);
    put("chocolate 3", 205, 102, 29);
    put("chocolate 4", 139, 69, 19);
    put("ivoryblack", 41, 36, 33);
    put("flesh", 255, 125, 64);
    put("cadmiumorange", 255, 97, 3);
    put("burntsienna", 138, 54, 15);
    put("sienna", 160, 82, 45);
    put("sienna 1", 255, 130, 71);
    put("sienna 2", 238, 121, 66);
    put("sienna 3", 205, 104, 57);
    put("sienna 4", 139, 71, 38);
    put("lightsalmon 1", 255, 160, 122);
    put("lightsalmon 2", 238, 149, 114);
    put("lightsalmon 3", 205, 129, 98);
    put("lightsalmon 4", 139, 87, 66);
    put("coral", 255, 127, 80);
    put("orangered 1", 255, 69, 0);
    put("orangered 2", 238, 64, 0);
    put("orangered 3", 205, 55, 0);
    put("orangered 4", 139, 37, 0);
    put("sepia", 94, 38, 18);
    put("darksalmon", 233, 150, 122);
    put("salmon 1", 255, 140, 105);
    put("salmon 2", 238, 130, 98);
    put("salmon 3", 205, 112, 84);
    put("salmon 4", 139, 76, 57);
    put("coral 1", 255, 114, 86);
    put("coral 2", 238, 106, 80);
    put("coral 3", 205, 91, 69);
    put("coral 4", 139, 62, 47);
    put("burntumber", 138, 51, 36);
    put("tomato 1", 255, 99, 71);
    put("tomato 2", 238, 92, 66);
    put("tomato 3", 205, 79, 57);
    put("tomato 4", 139, 54, 38);
    put("salmon", 250, 128, 114);
    put("mistyrose 1", 255, 228, 225);
    put("mistyrose 2", 238, 213, 210);
    put("mistyrose 3", 205, 183, 181);
    put("mistyrose 4", 139, 125, 123);
    put("snow 1", 255, 250, 250);
    put("snow 2", 238, 233, 233);
    put("snow 3", 205, 201, 201);
    put("snow 4", 139, 137, 137);
    put("rosybrown", 188, 143, 143);
    put("rosybrown 1", 255, 193, 193);
    put("rosybrown 2", 238, 180, 180);
    put("rosybrown 3", 205, 155, 155);
    put("rosybrown 4", 139, 105, 105);
    put("lightcoral", 240, 128, 128);
    put("indianred", 205, 92, 92);
    put("indianred 1", 255, 106, 106);
    put("indianred 2", 238, 99, 99);
    put("indianred 4", 139, 58, 58);
    put("indianred 3", 205, 85, 85);
    put("brown", 165, 42, 42);
    put("brown 1", 255, 64, 64);
    put("brown 2", 238, 59, 59);
    put("brown 3", 205, 51, 51);
    put("brown 4", 139, 35, 35);
    put("firebrick", 178, 34, 34);
    put("firebrick 1", 255, 48, 48);
    put("firebrick 2", 238, 44, 44);
    put("firebrick 3", 205, 38, 38);
    put("firebrick 4", 139, 26, 26);
    put("red 1", 255, 0, 0);
    put("red 2", 238, 0, 0);
    put("red 3", 205, 0, 0);
    put("red 4", 139, 0, 0);
    put("maroon*", 128, 0, 0);
    put("sgi beet", 142, 56, 142);
    put("sgi slateblue", 113, 113, 198);
    put("sgi lightblue", 125, 158, 192);
    put("sgi teal", 56, 142, 142);
    put("sgi chartreuse", 113, 198, 113);
    put("sgi olivedrab", 142, 142, 56);
    put("sgi brightgray", 197, 193, 170);
    put("sgi salmon", 198, 113, 113);
    put("sgi darkgray", 85, 85, 85);
    put("sgi gray 12", 30, 30, 30);
    put("sgi gray 16", 40, 40, 40);
    put("sgi gray 32", 81, 81, 81);
    put("sgi gray 36", 91, 91, 91);
    put("sgi gray 52", 132, 132, 132);
    put("sgi gray 56", 142, 142, 142);
    put("sgi lightgray", 170, 170, 170);
    put("sgi gray 72", 183, 183, 183);
    put("sgi gray 76", 193, 193, 193);
    put("sgi gray 92", 234, 234, 234);
    put("sgi gray 96", 244, 244, 244);
    put("white*", 255, 255, 255);
    put("white smoke", 245, 245, 245);
    put("gainsboro", 220, 220, 220);
    put("lightgrey", 211, 211, 211);
    put("silver*", 192, 192, 192);
    put("darkgray", 169, 169, 169);
    put("gray*", 128, 128, 128);
    put("dimgray", 105, 105, 105);
    put("black*", 0, 0, 0);
    put("gray 99", 252, 252, 252);
    put("gray 98", 250, 250, 250);
    put("gray 97", 247, 247, 247);
    put("white smoke", 245, 245, 245);
    put("gray 95", 242, 242, 242);
    put("gray 94", 240, 240, 240);
    put("gray 93", 237, 237, 237);
    put("gray 92", 235, 235, 235);
    put("gray 91", 232, 232, 232);
    put("gray 90", 229, 229, 229);
    put("gray 89", 227, 227, 227);
    put("gray 88", 224, 224, 224);
    put("gray 87", 222, 222, 222);
    put("gray 86", 219, 219, 219);
    put("gray 85", 217, 217, 217);
    put("gray 84", 214, 214, 214);
    put("gray 83", 212, 212, 212);
    put("gray 82", 209, 209, 209);
    put("gray 81", 207, 207, 207);
    put("gray 80", 204, 204, 204);
    put("gray 79", 201, 201, 201);
    put("gray 78", 199, 199, 199);
    put("gray 77", 196, 196, 196);
    put("gray 76", 194, 194, 194);
    put("gray 75", 191, 191, 191);
    put("gray 74", 189, 189, 189);
    put("gray 73", 186, 186, 186);
    put("gray 72", 184, 184, 184);
    put("gray 71", 181, 181, 181);
    put("gray 70", 179, 179, 179);
    put("gray 69", 176, 176, 176);
    put("gray 68", 173, 173, 173);
    put("gray 67", 171, 171, 171);
    put("gray 66", 168, 168, 168);
    put("gray 65", 166, 166, 166);
    put("gray 64", 163, 163, 163);
    put("gray 63", 161, 161, 161);
    put("gray 62", 158, 158, 158);
    put("gray 61", 156, 156, 156);
    put("gray 60", 153, 153, 153);
    put("gray 59", 150, 150, 150);
    put("gray 58", 148, 148, 148);
    put("gray 57", 145, 145, 145);
    put("gray 56", 143, 143, 143);
    put("gray 55", 140, 140, 140);
    put("gray 54", 138, 138, 138);
    put("gray 53", 135, 135, 135);
    put("gray 52", 133, 133, 133);
    put("gray 51", 130, 130, 130);
    put("gray 50", 127, 127, 127);
    put("gray 49", 125, 125, 125);
    put("gray 48", 122, 122, 122);
    put("gray 47", 120, 120, 120);
    put("gray 46", 117, 117, 117);
    put("gray 45", 115, 115, 115);
    put("gray 44", 112, 112, 112);
    put("gray 43", 110, 110, 110);
    put("gray 42", 107, 107, 107);
    put("dimgray", 105, 105, 105);
    put("gray 40", 102, 102, 102);
    put("gray 39", 99, 99, 99);
    put("gray 38", 97, 97, 97);
    put("gray 37", 94, 94, 94);
    put("gray 36", 92, 92, 92);
    put("gray 35", 89, 89, 89);
    put("gray 34", 87, 87, 87);
    put("gray 33", 84, 84, 84);
    put("gray 32", 82, 82, 82);
    put("gray 31", 79, 79, 79);
    put("gray 30", 77, 77, 77);
    put("gray 29", 74, 74, 74);
    put("gray 28", 71, 71, 71);
    put("gray 27", 69, 69, 69);
    put("gray 26", 66, 66, 66);
    put("gray 25", 64, 64, 64);
    put("gray 24", 61, 61, 61);
    put("gray 23", 59, 59, 59);
    put("gray 22", 56, 56, 56);
    put("gray 21", 54, 54, 54);
    put("gray 20", 51, 51, 51);
    put("gray 19", 48, 48, 48);
    put("gray 18", 46, 46, 46);
    put("gray 17", 43, 43, 43);
    put("gray 16", 41, 41, 41);
    put("gray 15", 38, 38, 38);
    put("gray 14", 36, 36, 36);
    put("gray 13", 33, 33, 33);
    put("gray 12", 31, 31, 31);
    put("gray 11", 28, 28, 28);
    put("gray 10", 26, 26, 26);
    put("gray 9", 23, 23, 23);
    put("gray 8", 20, 20, 20);
    put("gray 7", 18, 18, 18);
    put("gray 6", 15, 15, 15);
    put("gray 5", 13, 13, 13);
    put("gray 4", 10, 10, 10);
    put("gray 3", 8, 8, 8);
    put("gray 2", 5, 5, 5);
    put("gray 1", 3, 3, 3);
  }

  public static void put(String name, int r, int g, int b) {
    COLOR_LIBRARY.put(name, new NamedColor(name, r, g, b));
  }

  public static NamedColor getRandom() {
    Object[] values = COLOR_LIBRARY.values().toArray();
    Object randomValue = values[RANDOM.nextInt(values.length)];
    return (NamedColor) randomValue;
  }

}
