/**
 * Copyright 2016 vip.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 *  the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * </p>
 **/

package com.vip.saturn.job;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class SaturnJobExecutionContext implements Serializable {
	private static final long serialVersionUID = -5213585560266060611L;

	/**
	 * 作业名称.
	 */
	private String jobName;

	/**
	 * 分片总数.
	 */
	private int shardingTotalCount;

	/**
	 * 作业自定义参数. 可以配置多个相同的作业, 但是用不同的参数作为不同的调度实例.
	 */
	private String jobParameter;

	/**
	 * 获取到的本片
	 */
	private List<Integer> shardingItems;

	private String queueName;

	/**
	 * 运行在本作业项的分片序列号和个性化参数列表.
	 */
	private Map<Integer, String> shardingItemParameters;

	/**
	 * 自定义上下文
	 */
	private Map<String, String> customContext;

	public SaturnJobExecutionContext() {

	}

	public void copyFrom(Object source) {
		Class<?> clazz = source.getClass();
		try {
			Field field = null;
			Object res = null;

			field = clazz.getDeclaredField("jobName");
			field.setAccessible(true);
			res = field.get(source);
			if (res != null) {
				this.jobName = (String) res;
			}

			field = clazz.getDeclaredField("shardingTotalCount");
			field.setAccessible(true);
			res = field.get(source);
			if (res != null) {
				this.shardingTotalCount = (int) res;
			}

			field = clazz.getDeclaredField("jobParameter");
			field.setAccessible(true);
			res = field.get(source);
			if (res != null) {
				this.jobParameter = (String) res;
			}

			field = clazz.getDeclaredField("shardingItems");
			field.setAccessible(true);
			res = field.get(source);
			if (res != null) {
				this.shardingItems = (List) res;
			}

			field = clazz.getDeclaredField("shardingItemParameters");
			field.setAccessible(true);
			res = field.get(source);
			if (res != null) {
				this.shardingItemParameters = (Map) res;
			}

			field = clazz.getDeclaredField("customContext");
			field.setAccessible(true);
			res = field.get(source);
			if (res != null) {
				this.customContext = (Map) res;
			}

			field = clazz.getDeclaredField("queueName");
			field.setAccessible(true);
			res = field.get(source);
			if (res != null) {
				this.queueName = (String) res;
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getShardingTotalCount() {
		return shardingTotalCount;
	}

	public void setShardingTotalCount(int shardingTotalCount) {
		this.shardingTotalCount = shardingTotalCount;
	}

	public String getJobParameter() {
		return jobParameter;
	}

	public void setJobParameter(String jobParameter) {
		this.jobParameter = jobParameter;
	}

	public List<Integer> getShardingItems() {
		return shardingItems;
	}

	public void setShardingItems(List<Integer> shardingItems) {
		this.shardingItems = shardingItems;
	}

	public Map<Integer, String> getShardingItemParameters() {
		return shardingItemParameters;
	}

	public void setShardingItemParameters(Map<Integer, String> shardingItemParameters) {
		this.shardingItemParameters = shardingItemParameters;
	}

	public Map<String, String> getCustomContext() {
		return customContext;
	}

	public void setCustomContext(Map<String, String> customContext) {
		this.customContext = customContext;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
}
