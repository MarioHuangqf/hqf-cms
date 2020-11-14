//package com.cms.yxf;
//
//import com.cms.yxf.model.dto.UserDTO;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.task.AsyncListenableTaskExecutor;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.util.concurrent.ListenableFuture;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.*;
//
////@RunWith(SpringRunner.class)
//@SpringBootTest
//public class YxfApplicationTests {
//
//    @Test
//    public void test1() {
//        Map map = new HashMap();
//        map.put("1","1");
//        System.out.println(map.put("1","2"));
//        UserDTO userDTO = new UserDTO();
//        String email = "a";
//        userDTO.setEmail(email);
//        email = "b";
//        System.out.println(userDTO.getEmail());
//    }
//
//	// 测试future
//	@Test
//	public void contextLoads() throws Exception{
//		SquareCalculator squareCalculator = new SquareCalculator();
//
//		Future<Integer> future1 = squareCalculator.calculate(10);
//		Future<Integer> future2 = squareCalculator.calculate(100);
//
//		while (!(future1.isDone() && future2.isDone())) {
//			System.out.println(
//					String.format(
//							"future1 is %s and future2 is %s",
//							future1.isDone() ? "done" : "not done",
//							future2.isDone() ? "done" : "not done"
//					)
//			);
//			Thread.sleep(1000);
//		}
//
//		Integer result1 = future1.get();
//		Integer result2 = future2.get();
//
//		System.out.println("结果：" + result1 + " and " + result2);
//
//		squareCalculator.shutDown();
//	}
//
//	@Test
//	public void testCountDownLatch() {
//		ExecutorService executorService = Executors.newFixedThreadPool(3);
//		CountDownLatch countDownLatch = new CountDownLatch(3);
//		for (int i=0; i<3; i++) {
//			executorService.submit(() -> {
//				System.out.println(Thread.currentThread().getId());
//				countDownLatch.countDown();
//			});
//		}
//		try {
//			countDownLatch.wait();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("执行结束");
//	}
//
//	@Test
//	public void test() {
//		final CountDownLatch latch = new CountDownLatch(2);
//		System.out.println("主线程开始执行…… ……");
//		//第一个子线程执行
//		ExecutorService es1 = Executors.newFixedThreadPool(2);
//		es1.execute(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(3000);
//					System.out.println("子线程："+Thread.currentThread().getName()+"执行");
//					service();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				} finally {
//					latch.countDown();
//				}
//			}
//		});
//		System.out.println("等待两个线程执行完毕…… ……");
//		try {
//			latch.await();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("两个子线程都执行完毕，继续执行主线程");
//	}
//
//	public void service() {
//		System.out.println("调用方法");
//	}
//}
//
//class SquareCalculator {
//	private ExecutorService executorService = Executors.newFixedThreadPool(3);
//	public Future<Integer> calculate(Integer input) {
//		return executorService.submit(() -> {
//			Thread.sleep(2000);
//			System.out.println("当前线程：" + Thread.currentThread().getId());
//			return input * input;
//		});
//	}
//
//	public void shutDown() {
//		executorService.shutdown();
//	}
//}
