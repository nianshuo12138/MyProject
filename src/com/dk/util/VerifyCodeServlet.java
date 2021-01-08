package com.dk.util;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/code")
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//����ͼƬ
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1 �ߺͿ�
		int height = 30;
		int width = 60;
		String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		//2 ����һ��ͼƬ
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//3 ��û���
		Graphics g = image.getGraphics();
		//4 ���һ������
		// * ������ɫ
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.fillRect(1, 1, width - 2, height - 2);
		// * ��������
		g.setFont(new Font("����", Font.BOLD | Font.ITALIC, 25));


		//5 д�����
		String strC ="";

		for (int i = 0; i < 4; i++) {
			// ������ɫ--�����
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			// ��������
			int index = random.nextInt(data.length());
			String str = data.substring(index, index + 1);
			strC += str;
			// д��
			g.drawString(str, width / 6 * (i + 1), 20);

			HttpSession session = request.getSession();
			session.setAttribute("checkImgCode",strC);

		}



		//6 ������
		for (int i = 0; i < 3; i++) {
			// ������ɫ--�����
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			// ���������
			g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
			// �����
			g.drawOval(random.nextInt(width), random.nextInt(height), 2, 2);
		}
		//end ��ͼƬ��Ӧ�������
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
