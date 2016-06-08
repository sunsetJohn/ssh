package com.ben.union.subclass;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HibernateTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	//����������Session ��Transaction ������Ϊ��Ա���������в�������

	@Before
	public void init()
	{
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = 
				new ServiceRegistryBuilder().applySettings(configuration.getProperties())
											.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	
	@After
	public void destroy()
	{
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	/*
	 * �ŵ㣺
	 * 1. ʹ���˱������
	 * 2. ������е��ֶβ������ӷǿ�Լ��
	 * ȱ�㣺
	 * 1. ���������ֶ�
	 * 2. �����¸����ֶΣ� �����Ч�ʵ�
	 */
	@Test
	public void testUpdate()
	{
		String hql = "UPDATE Person p SET p.age = 20";
		session.createQuery(hql).executeUpdate();
	}
	/*
	 * ��̬��ѯ��
	 * 1. ��ѯ�����¼�� ��Ѹ������ӱ���¼���ܵ�һ���ٲ�ѯ�������Բ�Ӳ�ѯ��
	 * 2. ���������¼�� ֻ��Ҫ��ѯһ�����ݱ�
	 */
	@Test
	public void testQuery()
	{
		List<Person> persons = session.createQuery("FROM Person").list();
		System.out.println(persons.size());
		
		List<Student> students = session.createQuery("FROM Student").list();
		System.out.println(students.size());
	}
	/*
	 * ���������
	 * 1. �����������ֻ��Ѽ�¼���뵽һ�����ݱ���
	 */
	@Test
	public void testSave()
	{
		Person person = new Person();
		person.setAge(11);
		person.setName("AA");
		
		session.save(person);
		
		Student student = new Student();
		student.setAge(22);
		student.setName("BB");
		student.setSchool("BEN");
		
		session.save(student);
	}
}