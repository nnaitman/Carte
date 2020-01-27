package carte;

/**
 * @author cvericel
 *
 * Cette class va s'occuper de l'affichage des cartes 
 */
public class PicturePath {

	/*
	 * @param key, c'est la clef de la cartes
	 * @return String, cela représente le chemin pour acceder a l'image
	 */
	public static String getPicturePath(int key) {
		String path;
		switch(key) {
		
		case 141:
			path="resources\\images\\14_3.png";
		break;
		
		case 142:
			path="resources\\images\\14_0.png";
		break;
		
		case 143:
			path="resources\\images\\14_1.png";
		break;
		
		case 144:
			path="resources\\images\\14_2.png";
		break;
		
		case 201:
			path="resources\\images\\20_3.png";
		break;
		
		case 202:
			path="resources\\images\\20_0.png";
		break;
		
		case 203:
			path="resources\\images\\20_1.png";
		break;
		
		case 204:
			path="resources\\images\\20_2.png";
		break;
		
		case 31:
			path="resources\\images\\3_3.png";
		break;
		
		case 32:
			path="resources\\images\\3_0.png";
		break;
		
		case 33:
			path="resources\\images\\3_1.png";
		break;
		
		case 34:
			path="resources\\images\\3_2.png";
		break;
		
		case 41:
			path="resources\\images\\4_3.png";
		break;
		
		case 42:
			path="resources\\images\\4_0.png";
		break;
		
		case 43:
			path="resources\\images\\4_1.png";
		break;
		
		case 44:
			path="resources\\images\\4_2.png";
		break;
		
		case 51:
			path="resources\\images\\5_3.png";
		break;
		
		case 52:
			path="resources\\images\\5_0.png";
		break;
		
		case 53:
			path="resources\\images\\5_1.png";
		break;
		
		case 54:
			path="resources\\images\\5_2.png";
		break;
		
		case 61:
			path="resources\\images\\6_3.png";
		break;
		
		case 62:
			path="resources\\images\\6_0.png";
		break;
		
		case 63:
			path="resources\\images\\6_1.png";
		break;
		
		case 64:
			path="resources\\images\\6_2.png";
		break;
		
		case 71:
			path="resources\\images\\7_3.png";
		break;
		
		case 72:
			path="resources\\images\\7_0.png";
		break;
		
		case 73:
			path="resources\\images\\7_1.png";
		break;
		
		case 74:
			path="resources\\images\\7_2.png";
		break;
		
		case 81:
			path="resources\\images\\8_3.png";
		break;
		
		case 82:
			path="resources\\images\\8_0.png";
		break;
	
		case 83:
			path="resources\\images\\8_1.png";
		break;
		
		case 84:
			path="resources\\images\\8_2.png";
		break;
		
		case 91:
			path="resources\\images\\9_3.png";
		break;
		
		case 92:
			path="resources\\images\\9_0.png";
		break;
		
		case 93:
			path="resources\\images\\9_1.png";
		break;
		
		case 94:
			path="resources\\images\\9_2.png";
		break;
		
		case 101:
			path="resources\\images\\10_3.png";
		break;
		
		case 102:
			path="resources\\images\\10_0.png";
		break;
		
		case 103:
			path="resources\\images\\10_1.png";
		break;
		
		case 104:
			path="resources\\images\\10_2.png";
		break;
		
		case 111:
			path="resources\\images\\11_3.png";
		break;
		
		case 112:
			path="resources\\images\\11_0.png";
		break;
		
		case 113:
			path="resources\\images\\11_1.png";
		break;
		
		case 114:
			path="resources\\images\\11_2.png";
		break;
		
		case 121:
			path="resources\\images\\12_3.png";
		break;
		
		case 122:
			path="resources\\images\\12_0.png";
		break;
		
		case 123:
			path="resources\\images\\12_1.png";
		break;
		
		case 124:
			path="resources\\images\\12_2.png";
		break;
	
		case 131:
			path="resources\\images\\13_3.png";
		break;
		
		case 132:
			path="resources\\images\\13_0.png";
		break;
		
		case 133:
			path="resources\\images\\13_1.png";
		break;
		
		case 134:
			path="resources\\images\\13_2.png";
		break;
		
		default:
			path="resources\\images\\Joker.png";
		}
		return path;
	}
	
}
