/*
 * Copyright 2011 San Diego Association of Governments (SANDAG)
 * 
 * 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations
 * under the License.
 */
package org.sandag.popsyn.io.mybatis;

import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.sandag.popsyn.domain.Household;
import org.sandag.popsyn.io.IReaderDao;

/**
 * This class implements the IReaderDao interface.
 * 
 */
public class ReaderDao
        extends SqlSessionDaoSupport
        implements IReaderDao
{
    private static final String DOMAIN_PATH = "org.sandag.popsyn.io.mybatis";
 

    @SuppressWarnings("unchecked")
    public List<Household> getAllBySource(int sourceId)
    {
        return getSqlSession().selectList(DOMAIN_PATH + ".Household.getAllBySource", sourceId);
    }

    public Household getByIdAndSource(String id, int sourceId)
    {
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        paramMap.put("sourceId", sourceId);

        return (Household) getSqlSession().selectOne(DOMAIN_PATH + ".Household.getByIdAndSource",
                paramMap);
    }
}
